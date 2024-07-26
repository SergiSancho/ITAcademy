package dao.jdbc;

import dao.TreeDao;
import model.Tree;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TreeDaoJdbc extends GenericJdbcDao<Tree<Integer>, Integer> implements TreeDao<Integer> {

    private static final Logger logger = Logger.getLogger(TreeDaoJdbc.class.getName());

    public TreeDaoJdbc(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Tree<Integer> entity) {
        String insertProductSql = "INSERT INTO product (name, stock, price, type) VALUES (?, ?, ?, ?)";
        String insertTreeSql = "INSERT INTO tree (id_product, height) VALUES (?, ?)";

        try {
            connection.setAutoCommit(false);

            int productId;
            try (PreparedStatement productPstmt = connection.prepareStatement(insertProductSql, Statement.RETURN_GENERATED_KEYS)) {
                productPstmt.setString(1, entity.getName());
                productPstmt.setInt(2, entity.getStock());
                productPstmt.setDouble(3, entity.getPrice());
                productPstmt.setString(4, Product.Type.TREE.name());
                productPstmt.executeUpdate();

                ResultSet generatedKeys = productPstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    productId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Error al obtener ID del producto");
                }
            }

            try (PreparedStatement treePstmt = connection.prepareStatement(insertTreeSql)) {
                treePstmt.setInt(1, productId);
                treePstmt.setDouble(2, entity.getHeight());
                treePstmt.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al insertar árbol en la base de datos", e);
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
    public Tree<Integer> read(Integer id) {
        String sql = "SELECT t.id_product, p.name, p.stock, p.price, t.height FROM tree t JOIN product p ON t.id_product = p.id_product WHERE t.id_product = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Tree<>(
                        rs.getInt("id_product"),
                        rs.getString("name"),
                        rs.getInt("stock"),
                        rs.getDouble("price"),
                        rs.getDouble("height")
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al leer árbol por ID", e);
        }
        return null;
    }

    @Override
    public void update(Tree<Integer> entity) {
        String updateProductSql = "UPDATE product SET name = ?, stock = ?, price = ? WHERE id_product = ?";
        String updateTreeSql = "UPDATE tree SET height = ? WHERE id_product = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement productPstmt = connection.prepareStatement(updateProductSql)) {
                productPstmt.setString(1, entity.getName());
                productPstmt.setInt(2, entity.getStock());
                productPstmt.setDouble(3, entity.getPrice());
                productPstmt.setInt(4, entity.getId());
                productPstmt.executeUpdate();
            }

            try (PreparedStatement treePstmt = connection.prepareStatement(updateTreeSql)) {
                treePstmt.setDouble(1, entity.getHeight());
                treePstmt.setInt(2, entity.getId());
                treePstmt.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar árbol", e);
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
        String deleteTreeSql = "DELETE FROM tree WHERE id_product = ?";
        String deleteProductSql = "DELETE FROM product WHERE id_product = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement treePstmt = connection.prepareStatement(deleteTreeSql)) {
                treePstmt.setInt(1, id);
                treePstmt.executeUpdate();
            }

            try (PreparedStatement productPstmt = connection.prepareStatement(deleteProductSql)) {
                productPstmt.setInt(1, id);
                productPstmt.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar árbol", e);
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
    public List<Tree<Integer>> findAll() {
        return getAllTrees();
    }

    @Override
    public List<Tree<Integer>> getAllTrees() {
        List<Tree<Integer>> trees = new ArrayList<>();
        String sql = "SELECT t.id_product, p.name, p.stock, p.price, t.height FROM tree t JOIN product p ON t.id_product = p.id_product";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Tree<Integer> tree = new Tree<>(
                        rs.getInt("id_product"),
                        rs.getString("name"),
                        rs.getInt("stock"),
                        rs.getDouble("price"),
                        rs.getDouble("height")
                );
                trees.add(tree);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener árboles", e);
        }
        return trees;
    }

    @Override
    public int getTotalStockForTrees() {
        String sql = "SELECT SUM(p.stock) AS total_stock FROM tree t JOIN product p ON t.id_product = p.id_product";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt("total_stock");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener stock total de árboles", e);
        }
        return 0;
    }

    @Override
    public double getTotalValueForTrees() {
        String sql = "SELECT SUM(p.stock * p.price) AS total_value FROM tree t JOIN product p ON t.id_product = p.id_product";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble("total_value");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener el valor total de árboles", e);
        }
        return 0.0;
    }
}

