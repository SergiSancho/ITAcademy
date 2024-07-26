package dao.jdbc;

import dao.DecorationDao;
import model.Decoration;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DecorationDaoJdbc extends GenericJdbcDao<Decoration<Integer>, Integer> implements DecorationDao<Integer> {

    private static final Logger logger = Logger.getLogger(DecorationDaoJdbc.class.getName());

    public DecorationDaoJdbc(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Decoration<Integer> entity) {
        String insertProductSql = "INSERT INTO product (name, stock, price, type) VALUES (?, ?, ?, ?)";
        String insertDecorationSql = "INSERT INTO decoration (id_product, material) VALUES (?, ?)";

        try {
            connection.setAutoCommit(false);

            int productId;
            try (PreparedStatement productPstmt = connection.prepareStatement(insertProductSql, Statement.RETURN_GENERATED_KEYS)) {
                productPstmt.setString(1, entity.getName());
                productPstmt.setInt(2, entity.getStock());
                productPstmt.setDouble(3, entity.getPrice());
                productPstmt.setString(4, Product.Type.DECORATION.name());
                productPstmt.executeUpdate();

                ResultSet generatedKeys = productPstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    productId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Error al obtener ID del producto");
                }
            }

            try (PreparedStatement decorationPstmt = connection.prepareStatement(insertDecorationSql)) {
                decorationPstmt.setInt(1, productId);
                decorationPstmt.setString(2, entity.getMaterial());
                decorationPstmt.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al insertar decoración en la base de datos", e);
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
    public Decoration<Integer> read(Integer id) {
        String sql = "SELECT d.id_product, p.name, p.stock, p.price, d.material FROM decoration d JOIN product p ON d.id_product = p.id_product WHERE d.id_product = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Decoration<>(
                        rs.getInt("id_product"),
                        rs.getString("name"),
                        rs.getInt("stock"),
                        rs.getDouble("price"),
                        rs.getString("material")
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al leer decoración por ID", e);
        }
        return null;
    }

    @Override
    public void update(Decoration<Integer> entity) {
        String updateProductSql = "UPDATE product SET name = ?, stock = ?, price = ? WHERE id_product = ?";
        String updateDecorationSql = "UPDATE decoration SET material = ? WHERE id_product = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement productPstmt = connection.prepareStatement(updateProductSql)) {
                productPstmt.setString(1, entity.getName());
                productPstmt.setInt(2, entity.getStock());
                productPstmt.setDouble(3, entity.getPrice());
                productPstmt.setInt(4, entity.getId());
                productPstmt.executeUpdate();
            }

            try (PreparedStatement decorationPstmt = connection.prepareStatement(updateDecorationSql)) {
                decorationPstmt.setString(1, entity.getMaterial());
                decorationPstmt.setInt(2, entity.getId());
                decorationPstmt.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar decoración", e);
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
        String deleteDecorationSql = "DELETE FROM decoration WHERE id_product = ?";
        String deleteProductSql = "DELETE FROM product WHERE id_product = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement decorationPstmt = connection.prepareStatement(deleteDecorationSql)) {
                decorationPstmt.setInt(1, id);
                decorationPstmt.executeUpdate();
            }

            try (PreparedStatement productPstmt = connection.prepareStatement(deleteProductSql)) {
                productPstmt.setInt(1, id);
                productPstmt.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar decoración", e);
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
    public List<Decoration<Integer>> findAll() {
        return getAllDecorations();
    }

    @Override
    public List<Decoration<Integer>> getAllDecorations() {
        List<Decoration<Integer>> decorations = new ArrayList<>();
        String sql = "SELECT d.id_product, p.name, p.stock, p.price, d.material FROM decoration d JOIN product p ON d.id_product = p.id_product";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Decoration<Integer> decoration = new Decoration<>(
                        rs.getInt("id_product"),
                        rs.getString("name"),
                        rs.getInt("stock"),
                        rs.getDouble("price"),
                        rs.getString("material")
                );
                decorations.add(decoration);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener decoraciones", e);
        }
        return decorations;
    }

    @Override
    public int getTotalStockForDecorations() {
        String sql = "SELECT SUM(p.stock) AS total_stock FROM decoration d JOIN product p ON d.id_product = p.id_product";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt("total_stock");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener stock total de decoraciones", e);
        }
        return 0;
    }

    @Override
    public double getTotalValueForDecorations() {
        String sql = "SELECT SUM(p.stock * p.price) AS total_value FROM decoration d JOIN product p ON d.id_product = p.id_product";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble("total_value");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener el valor total de decoraciones", e);
        }
        return 0.0;
    }
}
