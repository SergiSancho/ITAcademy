public class Pista extends Elemento {

    private int minutosEstimados;
    private String tematica;
    private double precioConIva;

    public Pista(String nombre, double precio, int minutosEstimados, String tematica) {
        super(nombre, precio);
        this.minutosEstimados = minutosEstimados;
        this.tematica = tematica;
        this.iva = Iva.IVA_PISTA;
        this.precioConIva = calcularPrecioConIva();
    }

    public double calcularPrecioConIva(){
        return precio + (precio * iva.getPorcentaje() );
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        this.precioConIva = calcularPrecioConIva();
    }

    public int getMinutosEstimados() {
        return minutosEstimados;
    }

    public void setMinutosEstimados(int minutosEstimados) {
        this.minutosEstimados = minutosEstimados;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public double getPrecioConIva() {
        return precioConIva;
    }

    @Override
    public String toString() {
        return "Pista{" +
                "nombre='" + nombre + '\'' +
                ", minutosEstimados=" + minutosEstimados +
                ", tematica='" + tematica + '\'' +
                ", precioConIva=" + precioConIva +
                ", id=" + id +
                ", precio=" + precio +
                ", iva=" + iva +
                '}';
    }
}
