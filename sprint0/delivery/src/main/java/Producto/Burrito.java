package Producto;

public class Burrito extends Producto {


    public Burrito(String nombre, double precio) {
        super(nombre, precio);
        this.regalo = "Pin";
    }

    @Override
    public void Regalo() {

    }
}
