package tasca1.n1;

import java.util.ArrayList;
import java.util.List;

public class Undo {

    private static Undo instancia;
    private final List<String> comandesHistorial;

    private Undo() {
        comandesHistorial = new ArrayList<>();
    }

    public static synchronized Undo getInstancia() {
        if (instancia == null) {
            instancia = new Undo();
        }
        return instancia;
    }

    public void afegirComando(String comando) {
        comandesHistorial.add(comando);
        System.out.println("Comando afegit");
    }

    public void eliminarComando(int index) {
        if (comandesHistorial.isEmpty()) {
            System.out.println("No hi ha cap comando al historial");
        } else if (index >= 0 && index < comandesHistorial.size()) {
            comandesHistorial.remove(index);
            System.out.println("Comando eliminat");
        } else {
            System.out.println("Index no vàlid");
        }
    }

    public void llistarComandes() {
        if (comandesHistorial.isEmpty()) {
            System.out.println("No hi ha cap comando al historial");
        } else {
            for (int i = 0; i < comandesHistorial.size(); i++) {
                System.out.println(i + ". " + comandesHistorial.get(i));
            }
        }
    }
}
