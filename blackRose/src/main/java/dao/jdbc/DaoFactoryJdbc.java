package dao.jdbc;

import configdb.mysql.MysqlConnection;
import dao.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoFactoryJdbc extends DaoFactory {

    private static final Logger logger = Logger.getLogger(DaoFactoryJdbc.class.getName());
    private static DaoFactoryJdbc instance;
    private Connection connection;

    private TreeDao<Integer> treeDao;
    private FlowerDao<Integer> flowerDao;
    private DecorationDao<Integer> decorationDao;
    private TicketDao<Integer> ticketDao;
    private TicketDetailDao<Integer> ticketDetailDao;

    private DaoFactoryJdbc() {
        try {
            this.connection = MysqlConnection.getDbConnection();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener la conexión a la base de datos.", e);
        }
    }

     public static synchronized DaoFactoryJdbc getInstance() {
        if (instance == null) {
            instance = new DaoFactoryJdbc();
        }
        return instance;
    }


    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public TreeDao<Integer> getTreeDao() {
        if (treeDao == null) {
            treeDao = new TreeDaoJdbc(connection);
        }
        return treeDao;
    }

    @Override
    public FlowerDao<Integer> getFlowerDao() {
        if (flowerDao == null) {
            flowerDao = new FlowerDaoJdbc(connection);
        }
        return flowerDao;
    }

    @Override
    public DecorationDao<Integer> getDecorationDao() {
        if (decorationDao == null) {
            decorationDao = new DecorationDaoJdbc(connection);
        }
        return decorationDao;
    }

    @Override
    public TicketDao<Integer> getTicketDao() {
        if (ticketDao == null) {
            ticketDao = new TicketDaoJdbc(connection);
        }
        return ticketDao;
    }

    @Override
    public TicketDetailDao<Integer> getTicketDetailDao() {
        if (ticketDetailDao == null) {
            ticketDetailDao = new TicketDetailDaoJdbc(connection);
        }
        return ticketDetailDao;
    }
}


