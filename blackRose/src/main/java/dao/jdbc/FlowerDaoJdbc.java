package dao.jdbc;

import dao.FlowerDao;
import model.Flower;
import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlowerDaoJdbc extends GenericJdbcDao<Flower<Integer>, Integer> implements FlowerDao<Integer> {

    private static final Logger logger = Logger.getLogger(FlowerDaoJdbc.class.getName());


    public FlowerDaoJdbc(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Flower<Integer> entity) {
        String insertProductSql = "INSERT INTO product (name, stock, price, type) VALUES (?, ?, ?, ?)";
        String insertFlowerSql = "INSERT INTO flower (id_product, color) VALUES (?, ?)";

        try {
            connection.setAutoCommit(false);

            int productId;
            try (PreparedStatement productPstmt = connection.prepareStatement(insertProductSql, Statement.RETURN_GENERATED_KEYS)) {
                productPstmt.setString(1, entity.getName());
                productPstmt.setInt(2, entity.getStock());
                productPstmt.setDouble(3, entity.getPrice());
                productPstmt.setString(4, Product.Type.FLOWER.name());
                productPstmt.executeUpdate();

                ResultSet generatedKeys = productPstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    productId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Error al obtener ID del producto");
                }
            }


            try (PreparedStatement flowerPstmt = connection.prepareStatement(insertFlowerSql)) {
                flowerPstmt.setInt(1, productId);
                flowerPstmt.setString(2, entity.getColour());
                flowerPstmt.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al insertar flor en la base de datos", e);
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                logger.log(Level.SEVERE, "Error al deshacer la transacción", rollbackEx);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error al restaurar el modo auto-commit", e);
            }
        }
    }

    @Override
    public Flower<Integer> read(Integer id) {
        String sql = "SELECT f.id_product, p.name, p.stock, p.price, f.color FROM flower f JOIN product p ON f.id_product = p.id_product WHERE f.id_product = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Flower<>(
                        rs.getInt("id_product"),
                        rs.getString("name"),
                        rs.getInt("stock"),
                        rs.getDouble("price"),
                        rs.getString("color")
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al leer flor por ID", e);
        }
        return null;
    }

    @Override
    public void update(Flower<Integer> entity) {
        String updateProductSql = "UPDATE product SET name = ?, stock = ?, price = ? WHERE id_product = ?";
        String updateFlowerSql = "UPDATE flower SET color = ? WHERE id_product = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement productPstmt = connection.prepareStatement(updateProductSql)) {
                productPstmt.setString(1, entity.getName());
                productPstmt.setInt(2, entity.getStock());
                productPstmt.setDouble(3, entity.getPrice());
                productPstmt.setInt(4, entity.getId());
                productPstmt.executeUpdate();
            }

            try (PreparedStatement flowerPstmt = connection.prepareStatement(updateFlowerSql)) {
                flowerPstmt.setString(1, entity.getColour());
                flowerPstmt.setInt(2, entity.getId());
                flowerPstmt.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar flor", e);
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                logger.log(Level.SEVERE, "Error al deshacer la transacción", rollbackEx);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error al restaurar el modo auto-commit", e);
            }
        }
    }

    @Override
    public void deleteById(Integer id) {
        String deleteFlowerSql = "DELETE FROM flower WHERE id_product = ?";
        String deleteProductSql = "DELETE FROM product WHERE id_product = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement flowerPstmt = connection.prepareStatement(deleteFlowerSql)) {
                flowerPstmt.setInt(1, id);
                flowerPstmt.executeUpdate();
            }

            try (PreparedStatement productPstmt = connection.prepareStatement(deleteProductSql)) {
                productPstmt.setInt(1, id);
                productPstmt.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar flor", e);
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                logger.log(Level.SEVERE, "Error al deshacer la transacción", rollbackEx);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error al restaurar el modo auto-commit", e);
            }
        }
    }

    @Override
    public List<Flower<Integer>> findAll() {
        return getAllFlowers();
    }

    @Override
    public List<Flower<Integer>> getAllFlowers() {
        List<Flower<Integer>> flowers = new ArrayList<>();
        String sql = "SELECT f.id_product, p.name, p.stock, p.price, f.color FROM flower f JOIN product p ON f.id_product = p.id_product";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Flower<Integer> flower = new Flower<>(
                        rs.getInt("id_product"),
                        rs.getString("name"),
                        rs.getInt("stock"),
                        rs.getDouble("price"),
                        rs.getString("color")
                );
                flowers.add(flower);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener flores", e);
        }
        return flowers;
    }

    @Override
    public int getTotalStockForFlowers() {
        String sql = "SELECT SUM(p.stock) AS total_stock FROM flower f JOIN product p ON f.id_product = p.id_product";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt("total_stock");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener stock total de flores", e);
        }
        return 0;
    }

    @Override
    public double getTotalValueForFlowers() {
        String sql = "SELECT SUM(p.stock * p.price) AS total_value FROM flower f JOIN product p ON f.id_product = p.id_product";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble("total_value");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener el valor total de flores", e);
        }
        return 0.0;
    }
}
