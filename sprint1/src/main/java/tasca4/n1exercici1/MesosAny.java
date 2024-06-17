package tasca4.n1exercici1;

import java.util.ArrayList;
import java.util.List;

public class MesosAny {

    private List<String > llistaMesos;

    public MesosAny(){
        llistaMesos = new ArrayList<>();
        llistaMesos.add("Gener");
        llistaMesos.add("Febrer");
        llistaMesos.add("Març");
        llistaMesos.add("Abril");
        llistaMesos.add("Maig");
        llistaMesos.add("Juny");
        llistaMesos.add("Juliol");
        llistaMesos.add("Agost");
        llistaMesos.add("Setembre");
        llistaMesos.add("Octubre");
        llistaMesos.add("Novembre");
        llistaMesos.add("Desembre");
    }

    public List<String> getLlistaMesos() {
        return llistaMesos;
    }
}
