/*public class FlowerShop {

    private static FlowerShop instance;
    private ProductController<Integer> productController;
    private TicketController<Integer> ticketController;

    // Singleton pattern
    private FlowerShop() {
        // Private constructor to prevent instantiation
    }

    public static FlowerShop getInstance() {
        if (instance == null) {
            instance = new FlowerShop();
        }
        return instance;
    }

    public void initialize(DaoFactory daoFactory) {
        // Set the factory
        DaoFactory.setFactory(daoFactory);

        // Initialize DAOs
        FlowerDao<Integer> flowerDao = DaoFactory.getFactory().getFlowerDao();
        TreeDao<Integer> treeDao = DaoFactory.getFactory().getTreeDao();
        DecorationDao<Integer> decorationDao = DaoFactory.getFactory().getDecorationDao();
        TicketDao<Integer> ticketDao = DaoFactory.getFactory().getTicketDao();

        // Initialize controllers
        this.productController = new ProductController<>(flowerDao, treeDao, decorationDao);
        this.ticketController = new TicketController<>(ticketDao);
    }

    public void start() {
        Menu menu = new Menu(productController, ticketController);
        menu.start();
    }
}
/*public class Main {

    public static void main(String[] args) {
        // Choose the appropriate DAO factory (e.g., Jdbc, MongoDB)
        DaoFactory daoFactory = new DaoFactoryJdbc(); // Or DaoFactoryMongoDB, etc.

        // Initialize database if necessary
        initializeDatabase();

        // Initialize the FlowerShop singleton
        FlowerShop flowerShop = FlowerShop.getInstance();
        flowerShop.initialize(daoFactory);

        // Start the application
        flowerShop.start();
    }

    private static void initializeDatabase() {
        // Code to initialize database schema if needed
    }
}
*/
//SIN PASAR POR PARAMETRO
/*public class FlowerShop {

    private static FlowerShop instance;
    private ProductController<Integer> productController;
    private TicketController<Integer> ticketController;

    private FlowerShop() {}

    public static FlowerShop getInstance() {
        if (instance == null) {
            instance = new FlowerShop();
        }
        return instance;
    }

    public void initialize() {
        FlowerDao<Integer> flowerDao = DaoFactory.getFactory().getFlowerDao();
        TreeDao<Integer> treeDao = DaoFactory.getFactory().getTreeDao();
        DecorationDao<Integer> decorationDao = DaoFactory.getFactory().getDecorationDao();
        TicketDao<Integer> ticketDao = DaoFactory.getFactory().getTicketDao();

        this.productController = new ProductController<>(flowerDao, treeDao, decorationDao);
        this.ticketController = new TicketController<>(ticketDao);
    }

    public void start() {
        Menu menu = new Menu(productController, ticketController);
        menu.start();
    }
}
public class Main {

    public static void main(String[] args) {
        DaoFactory daoFactory = new DaoFactoryJdbc(); // O DaoFactoryMongoDB, etc.
        DaoFactory.setFactory(daoFactory);

        initializeDatabase();

        FlowerShop flowerShop = FlowerShop.getInstance();
        flowerShop.initialize();

        flowerShop.start();
    }

    private static void initializeDatabase() {
        // Code to initialize database schema if needed
    }
}
*/