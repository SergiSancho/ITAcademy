/*package dao.jdbc;

import dao.FlowerDao;
import dao.ProductDao;
import model.Flower;
import model.Product;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;

public class ProductDaoJdbc extends GenericJdbcDao<Product<Integer>, Integer> implements ProductDao<Integer> {


    public ProductDaoJdbc(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Product<Integer> entity) {
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
    public Product<Integer> read(Integer integer) {
        return null;
    }

    @Override
    public void update(Product<Integer> entity) {

    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public List<Product<Integer>> findAll() {
        return List.of();
    }
}

*/
