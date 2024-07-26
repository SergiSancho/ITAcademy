package flowershop.dao;

import flowershop.entities.*;

public interface FlowerDao<ID> extends GenericDao<Flower<ID>, ID> {

    int getTotalStockFlowers();

    double getTotalValueFlowers();
}
