package tasca1.n3;

import tasca1.n3.Ordre.*;

import java.util.ArrayList;
import java.util.List;

public class Invocador {

    private List<Ordre> llistaOrdres = new ArrayList<>();

    public void afegirOrdre (Ordre ordre) {
        llistaOrdres.add(ordre);
    }

    public void executarOrdres () {

        llistaOrdres.forEach(Ordre::executar);
        llistaOrdres.clear();
    }
}
