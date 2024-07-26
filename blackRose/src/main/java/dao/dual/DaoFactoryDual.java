/*package dao.dual;


import dao.*;

public class DaoFactoryDual extends DaoFactory {
    private final DaoFactory mysqlFactory;
    private final DaoFactory mongoFactory;

    public DaoFactoryDual(DaoFactory mysqlFactory, DaoFactory mongoFactory) {
        this.mysqlFactory = mysqlFactory;
        this.mongoFactory = mongoFactory;
    }

    @Override
    public TreeDao<Integer> getTreeDao() {
        return new DualTreeDao(mysqlFactory.getTreeDao(), mongoFactory.getTreeDao());
    }

    @Override
    public FlowerDao<Integer> getFlowerDao() {
        return new DualFlowerDao(mysqlFactory.getFlowerDao(), mongoFactory.getFlowerDao());
    }

    @Override
    public DecorationDao<Integer> getDecorationDao() {
        return new DualDecorationDao(mysqlFactory.getDecorationDao(), mongoFactory.getDecorationDao());
    }

    @Override
    public ProductDao<Integer> getProductDao() {
        return new DualProductDao(mysqlFactory.getProductDao(), mongoFactory.getProductDao());
    }

    @Override
    public TicketDao<Integer> getTicketDao() {
        return new DualTicketDao(mysqlFactory.getTicketDao(), mongoFactory.getTicketDao());
    }

    @Override
    public TicketDetailDao<Integer> getTicketDetailDao() {
        return new DualTicketDetailDao(mysqlFactory.getTicketDetailDao(), mongoFactory.getTicketDetailDao());
    }
}

*/