package configdb.mysql;

import dao.DaoFactory;
import dao.FlowerDao;
import dao.jdbc.DaoFactoryJdbc;
import model.Flower;

import java.util.List;

public class MainPrueba {
    public static void main(String[] args) {
        CreateDatabaseMysql.initializeDatabase();

        DaoFactory.setFactory(DaoFactoryJdbc.getInstance());

        FlowerDao  flowerDao = DaoFactory.getFactory().getFlowerDao();

        Flower flower = new Flower();
        flower.setName("amapola");
        flower.setStock(44);
        flower.setPrice(18.5);
        flower.setColour("verde");

        // Insertar la flor en la base de datos
        flowerDao.create(flower);

        List<Flower> flowers = flowerDao.findAll();

        // Imprimir todas las flores
        for (Flower f : flowers) {
            System.out.println(f);
        }

        //Flower<Integer> flower = flowerDao.read(2);

        //System.out.println(flower.toString());
    }
}
/* public static void main(String[] args) {
        DaoManagerMysql daoManager = null;
        try {
            daoManager = new DaoManagerMysql();
            Menu menu = new Menu(daoManager); // Pasamos daoManager a Menu
            menu.startMenu(); // Ejecutamos el menú
        } catch (Exception e) {
            System.out.println("Error en la aplicación: " + e.getMessage());
        } finally {
            if (daoManager != null) {
                daoManager.close(); // Cerramos la conexión aquí
            }
        }
    }
    public class DaoManagerMysql {
    private Connection connection;

    public DaoManagerMysql() {
        try {
            this.connection = MysqlConnection.getDbConnection();
        } catch (SQLException e) {
            // Manejo de excepción
            throw new RuntimeException("No se pudo establecer la conexión con la base de datos", e);
        }
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            // Manejo de excepción
        }
    }
    */