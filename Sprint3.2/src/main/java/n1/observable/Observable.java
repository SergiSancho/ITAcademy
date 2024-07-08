package n1.observable;

import n1.observador.Observador;

import java.util.HashSet;
import java.util.Set;

public class Observable {

    private final Set<Observador> observadors = new HashSet<>();

    public void afegirObservador (Observador observador) {
        this.observadors.add(observador);
    }

    public void eliminarObservador (Observador observador) {
        this.observadors.remove(observador);
    }

    public void notificarObservadors() {
        this.observadors.forEach(Observador::actualitzar);
    }
}
