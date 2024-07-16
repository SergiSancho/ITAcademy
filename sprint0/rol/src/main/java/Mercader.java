public class Mercader extends Vendedor {
    private static final int LIMIT_INVENTARIO = 7;
    public Mercader(String nombre, String ciudad) {
        super(nombre, ciudad);
        itemImpuesto = 1.04;
        itemDesgaste = 0;
    }

    @Override
    public void calcularPrecioImpuestosItem(Item item) {
        item.setPrecioConImpuesto(item.getPrecio() * itemImpuesto);
    }

    @Override
    public void calcularDesgasteItem(Item item) {
        item.setDesgaste(item.getDesgaste() - itemDesgaste);
    }

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
