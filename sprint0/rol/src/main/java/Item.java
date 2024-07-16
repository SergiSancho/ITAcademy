public class Item {
    String nombre;
    String tipo;
    double precio;
    double precioConImpuesto;
    int desgaste;

    public Item(String nombre, String tipo, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.desgaste = 100;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDesgaste() {
        return desgaste;
    }

    public void setDesgaste(int desgaste) {
        this.desgaste = desgaste;
    }

    public double getPrecioConImpuesto() {
        return precioConImpuesto;
    }

    public void setPrecioConImpuesto(double precioConImpuesto) {
        this.precioConImpuesto = precioConImpuesto;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", precioConImpuesto=" + precioConImpuesto +
                ", desgaste=" + desgaste +
                '}';
    }
}
