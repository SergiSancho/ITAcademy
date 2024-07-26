package flowershop.dao;

import flowershop.entities.*;


public interface TreeDao<ID> extends GenericDao<Tree<ID>, ID> {

    int getTotalStockTrees();

    double getTotalValueTrees();
}
