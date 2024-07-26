package flowershop.dao;

import flowershop.entities.Flower;

public interface FlowerDao extends GenericDao<Flower> {

    int getTotalStockFlowers();

    double getTotalValueFlowers();

    boolean exists(Flower flower) throws Exception;
}
