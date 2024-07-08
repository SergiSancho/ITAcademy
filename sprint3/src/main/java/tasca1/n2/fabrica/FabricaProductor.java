package tasca1.n2.fabrica;

public class FabricaProductor {

    public static FabricaAbstracta getFabrica(String tipusFabrica) {
        if ("espanya".equalsIgnoreCase(tipusFabrica)) {
            return new FabricaEspanya();
        } else if ("italia".equalsIgnoreCase(tipusFabrica)) {
            return new FabricaItalia();
        } else {
            return null;
        }
    }
}
