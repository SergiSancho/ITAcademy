/*package dao.mongo;

import configdb.mongo.MongoConnection;
import dao.*;

import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoFactoryMongo extends DaoFactory {

    private static final Logger logger = Logger.getLogger(DaoFactoryMongo.class.getName());
    private static DaoFactoryMongo instance;
    private MongoDatabase database;

    private TreeDao<Integer> treeDao;
    private FlowerDao<Integer> flowerDao;
    private DecorationDao<Integer> decorationDao;
    private ProductDao<Integer> productDao;
    private TicketDao<Integer> ticketDao;
    private TicketDetailDao<Integer> ticketDetailDao;

    private DaoFactoryMongo() {
        try {
            this.database = MongoConnection.getDatabase();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener la conexión a la base de datos.", e);
        }
    }

    public static DaoFactoryMongo getInstance() {
        if (instance == null) {
            synchronized (DaoFactoryMongo.class) {
                if (instance == null) {
                    instance = new DaoFactoryMongo();
                }
            }
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return this.database;
    }

    @Override
    public TreeDao<Integer> getTreeDao() {
        if (treeDao == null) {
            treeDao = new TreeDaoMongo(database);
        }
        return treeDao;
    }

    @Override
    public FlowerDao<Integer> getFlowerDao() {
        if (flowerDao == null) {
            flowerDao = new FlowerDaoMongo(database);
        }
        return flowerDao;
    }

    @Override
    public DecorationDao<Integer> getDecorationDao() {
        if (decorationDao == null) {
            decorationDao = new DecorationDaoMongo(database);
        }
        return decorationDao;
    }

    @Override
    public ProductDao<Integer> getProductDao() {
        if (productDao == null) {
            productDao = new ProductDaoMongo(database);
        }
        return productDao;
    }

    @Override
    public TicketDao<Integer> getTicketDao() {
        if (ticketDao == null) {
            ticketDao = new TicketDaoMongo(database);
        }
        return ticketDao;
    }

    @Override
    public TicketDetailDao<Integer> getTicketDetailDao() {
        if (ticketDetailDao == null) {
            ticketDetailDao = new TicketDetailDaoMongo(database);
        }
        return ticketDetailDao;
    }
}
*/