import java.util.ArrayList;

public class Pedido {

    private static int idContador = 1;
    private int id;
    private Cliente cliente;
    private List<Producto> productos;
    private double precio;
    private Repartidor repartidor;
    private String regalo;
    private boolean entregado;

    public Pedido(Cliente cliente, Repartidor repartidor) {
        this.id = idContador++;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        //this.precio = calcular precio total??
        this.repartidor = repartidor;  //METODO repartidor aleatorio??
        this.entregado = false;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
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

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }
}
