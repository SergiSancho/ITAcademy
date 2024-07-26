package dao;

import model.Tree;

import java.util.List;

public interface TreeDao<ID> extends GenericDao<Tree<ID>, ID> {

    List<Tree<Integer>> getAllTrees();

    int getTotalStockForTrees();

    double getTotalValueForTrees();
}
