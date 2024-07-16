public class RecursoDigital extends Documento{

    private FormatoDigital formato;

    public RecursoDigital(String titulo, double precio, FormatoDigital formato) {
        super(titulo, precio, Iva.RECURSODIGITAL);
        this.formato = formato;
    }

    public FormatoDigital getFormato() {
        return formato;
    }

    public void setFormato(FormatoDigital formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "RecursoDigital{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", formato=" + formato +
                ", iva=" + iva +
                ", precio=" + precio +
                ", precioConIva=" + precioConIva +
                '}';
    }
}
