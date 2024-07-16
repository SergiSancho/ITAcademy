public abstract class Elemento {

    protected static int idContador = 1;
    protected int id;
    protected String nombre;
    protected double precio;
    protected Iva iva;

    public Elemento(String nombre, double precio) {
        this.id = idContador++;
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract double calcularPrecioConIva();

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
