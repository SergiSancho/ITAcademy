package dao;

import model.Decoration;

import java.util.List;

public interface DecorationDao<ID> extends GenericDao<Decoration<ID>, ID>{

    List<Decoration<Integer>> getAllDecorations();

    int getTotalStockForDecorations();

    double getTotalValueForDecorations();
}
