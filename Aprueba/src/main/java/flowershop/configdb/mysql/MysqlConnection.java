package flowershop.configdb.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlConnection {

    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String MULTI_QUERIES = "?allowMultiQueries=true";
    protected static final String DB_NAME = "blackrose";

    private static Properties getDatabaseProperties() {
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASSWORD);
        return properties;
    }


    public static Connection getInitialConnection() throws SQLException {

        return DriverManager.getConnection(URL, getDatabaseProperties());
    }

    public static Connection getDbConnection() throws SQLException {

        return DriverManager.getConnection(URL + DB_NAME, getDatabaseProperties());
    }

    public static Connection getDbConnectionMultiQueries() throws SQLException {

        return DriverManager.getConnection(URL + DB_NAME + MULTI_QUERIES, getDatabaseProperties());
    }
}