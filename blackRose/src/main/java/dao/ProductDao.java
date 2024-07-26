package dao;
//ELIMINAR DAO PRODUCT, ESTOS METODOS ESTADISTICA EN PAQUETE SERVICE
import model.Product;

public interface ProductDao<ID> extends GenericDao<Product<ID>, ID> {
   // int getTotalStockForProducts();

    // double getTotalValueForProducts();
}
