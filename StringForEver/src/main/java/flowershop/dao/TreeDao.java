package flowershop.dao;

import flowershop.entities.Flower;
import flowershop.entities.Tree;


public interface TreeDao extends GenericDao<Tree> {

    int getTotalStockTrees();

    double getTotalValueTrees();

    boolean exists(Tree tree) throws Exception;
}
