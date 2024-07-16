public class Campesino extends Vendedor {
    private static final int LIMIT_INVENTARIO = 5;

    public Campesino(String nombre, String ciudad) {
        super(nombre, ciudad);
        itemImpuesto = 1.02;
        itemDesgaste = 15;
    }

    @Override
    public void calcularPrecioImpuestosItem(Item item) {
        item.setPrecioConImpuesto(item.getPrecio() * itemImpuesto);
    }

    @Override
    public void calcularDesgasteItem(Item item) {
        item.setDesgaste(item.getDesgaste() - itemDesgaste);
    }

    @Override
    public boolean afegirItemInventario (Item item) {
        if (this.inventario.size() < LIMIT_INVENTARIO){
            calcularPrecioImpuestosItem(item);
            calcularDesgasteItem(item);
            this.inventario.add(item);
            return true;
        }
        return false;
    }
}
