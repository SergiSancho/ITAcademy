package flowershop.dao;

import flowershop.entities.Decoration;
import flowershop.entities.Flower;


//SI LA ENTIDAD O MODELO NO TIENE ID GENERICO(SERVIRA O NO?):
//public interface DecorationDao extends GenericDao<DecorationDao> {
//public interface DecorationDao extends GenericDao<DecorationDao, Integer> {
public interface DecorationDao extends GenericDao<Decoration>{

    int getTotalStockDecorations();

    double getTotalValueDecorations();

    boolean exists(Decoration decoration) throws Exception;
}
