package dao;

public abstract class DaoFactory {

    private static DaoFactory factory = null;

    public static synchronized void setFactory(DaoFactory factory) {
        if (DaoFactory.factory == null) {
            DaoFactory.factory = factory;
        } else {
            throw new IllegalStateException("Factoria ya inicializada");
        }
    }

    public static DaoFactory getFactory() {
        if (factory == null) {
            throw new IllegalStateException("Factoria no inicializada");
        }
        return factory;
    }

    public abstract TreeDao getTreeDao();
    public abstract FlowerDao getFlowerDao();
    public abstract DecorationDao getDecorationDao();
    public abstract TicketDao getTicketDao();
    public abstract TicketDetailDao getTicketDetailDao();
}

