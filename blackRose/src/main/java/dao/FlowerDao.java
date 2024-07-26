package dao;

import java.util.List;
import model.Flower;

public interface FlowerDao<ID> extends GenericDao<Flower<ID>, ID>{

    List<Flower<ID>> getAllFlowers();

    int getTotalStockForFlowers();

    double getTotalValueForFlowers();
}
