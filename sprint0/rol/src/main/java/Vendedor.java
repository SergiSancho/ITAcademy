import java.util.ArrayList;
import java.util.List;

public abstract class Vendedor {
    protected String nombre;
    protected String ciudad;
    protected List<Item> inventario;
    protected double itemImpuesto;
    protected int itemDesgaste;

    public Vendedor(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.inventario = new ArrayList<>();
    }

    public abstract void calcularPrecioImpuestosItem(Item item);

    public abstract void calcularDesgasteItem(Item item);

    public abstract boolean afegirItemInventario (Item item);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Item> getInventario() {
        return inventario;
    }


    @Override
    public String toString() {
        return "Vendedor{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
