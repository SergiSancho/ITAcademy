public class Objeto extends Elemento {

    private String tipoMaterial;
    private double precioConIva;

    public Objeto(String nombre, double precio, String tipoMaterial) {
        super(nombre, precio);
        this.tipoMaterial = tipoMaterial;
        this.iva = Iva.IVA_OBJETO;
        this.precioConIva = calcularPrecioConIva();
    }

    public double calcularPrecioConIva(){
        return precio + (precio * iva.getPorcentaje() );
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        calcularPrecioConIva();
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public double getPrecioConIva() {
        return precioConIva;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "ID=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipoMaterial='" + tipoMaterial + '\'' +
                ", precioConIva=" + precioConIva +
                ", precio=" + precio +
                ", iva=" + iva +
                '}';
    }
}
