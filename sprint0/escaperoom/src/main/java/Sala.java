import java.util.ArrayList;
import java.util.List;

public class Sala {

    private static int idContador = 1;
    private int id;
    private String nombre;
    private TipoDificultad tipoDificultad;
    List<Pista> pistas;
    List<Objeto> objetos;

    public Sala(String nombre, TipoDificultad tipoDificultad) {
        this.id = idContador++;
        this.nombre = nombre;
        this.tipoDificultad = tipoDificultad;
        this.pistas = new ArrayList<>();
        this.objetos = new ArrayList<>();
    }

    public double calculaPrecioTotal() {
        double precioTotal = 0.0;
        if (pistas != null && !pistas.isEmpty()) {
            for (Pista pista : pistas) {
                precioTotal += pista.getPrecioConIva();
            }
        }
        if (objetos != null && !objetos.isEmpty()) {
            for (Objeto objeto : objetos) {
                precioTotal += objeto.getPrecioConIva();
            }
        }
        return precioTotal;
    }

    public void mostrarPistasSala() {
        if (pistas != null && !pistas.isEmpty()) {
            System.out.println("Pistas de la sala " + this.nombre);
            for (Pista pista : pistas) {
                System.out.println(pista);
            }
        } else {
            System.out.println("No hay pistas");
        }
    }

    public void mostrarObjetosSala() {
        if (objetos != null && !objetos.isEmpty()) {
            System.out.println("Objetos de la sala " + this.nombre);
            for (Objeto objeto : objetos) {
                System.out.println(objeto);
            }
        } else {
            System.out.println("No hay objetos");
        }
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

    public TipoDificultad getTipoDificultad() {
        return tipoDificultad;
    }

    public void setTipoDificultad(TipoDificultad tipoDificultad) {
        this.tipoDificultad = tipoDificultad;
    }

    public List<Pista> getPistas() {
        return pistas;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", tipoDificultad=" + tipoDificultad +
                ", pistas=" + pistas +
                ", objetos=" + objetos +
                '}';
    }
}
