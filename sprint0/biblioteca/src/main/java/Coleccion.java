import java.util.ArrayList;
import java.util.List;

public class Coleccion {

    private static int idContador = 1;
    private int id;
    private String nombre;
    private NivelAcceso nivelAcceso;
    private List<Documento> documentos;
    private double valor;

    public Coleccion(String nombre, NivelAcceso nivelAcceso) {
        this.id = idContador++;
        this.nombre = nombre;
        this.nivelAcceso = nivelAcceso;
        this.documentos = new ArrayList<>();

    }

    public double calcularValorColeccion(){
        double valor = 0.0;

        if(documentos != null && !documentos.isEmpty()){
            for (Documento documento : documentos) {
                valor += documento.getPrecioConIva();
            }
        }
        return valor;

        /*
        if(documentos != null && !documentos.isEmpty()){
        valor= documentos.stream()
                         .mapToDouble(Documento::getPrecioConIva)
                         .sum();
                         }*/
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NivelAcceso getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(NivelAcceso nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }


    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Coleccion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivelAcceso=" + nivelAcceso +
                ", documentos=" + documentos +
                ", valor=" + valor +
                '}';
    }
}
