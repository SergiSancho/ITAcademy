package Producto;

public abstract class Producto {

    protected String nombre;
    protected double precio;
    protected String regalo;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract void Regalo();//no tene sentido??

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

    public String getRegalo() {
        return regalo;
    }

    public void setRegalo(String regalo) {
        this.regalo = regalo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", regalo='" + regalo + '\'' +
                '}';
    }
}
