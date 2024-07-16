public class Documento {

    protected static int idContador = 1;
    protected int id;
    protected String titulo;
    protected double precio;
    protected Iva iva;
    protected double precioConIva;

    public Documento(String titulo, double precio, Iva iva) {
        this.id = idContador++;
        this.titulo = titulo;
        this.precio = precio;
        this.iva = iva;
        this.precioConIva = calcularPrecioConIva();
    }

    public double calcularPrecioConIva(){
        return precio + (precio * iva.getValor());
    }

    public double getPrecioConIva() {
        return precioConIva;
    }

    public Iva getIva() {
        return iva;
    }

    public void setIva(Iva iva) {
        this.iva = iva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        this.precioConIva = calcularPrecioConIva();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public static int getIdContador() {
        return idContador;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", iva=" + iva +
                ", precioConIva=" + precioConIva +
                '}';
    }
}
