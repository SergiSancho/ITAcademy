public class Libro extends Documento {

    private double tiempoDeLectura;
    private Categoria categoria;

    public Libro(String titulo, double precio, double tiempoDeLectura, Categoria categoria) {
        super(titulo, precio, Iva.LIBRO);
        this.tiempoDeLectura = tiempoDeLectura;
        this.categoria = categoria;
    }

    public double getTiempoDeLectura() {
        return tiempoDeLectura;
    }

    public void setTiempoDeLectura(double tiempoDeLectura) {
        this.tiempoDeLectura = tiempoDeLectura;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "tiempoDeLectura=" + tiempoDeLectura +
                ", categoria=" + categoria +
                ", id=" + id +
                ", titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", iva=" + iva +
                ", precioConIva=" + precioConIva +
                '}';
    }
}
