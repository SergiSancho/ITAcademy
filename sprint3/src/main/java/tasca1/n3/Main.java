package tasca1.n3;

import tasca1.n3.Ordre.FrenarOrdre;
import tasca1.n3.Ordre.*;
import tasca1.n3.Vehicle.*;


public class Main {

    public static void main(String[] args) {

        Vehicle bicicleta = new Bicicleta();
        Vehicle avio = new Avio();

        Ordre frenarBicicleta = new FrenarOrdre(bicicleta);
        Ordre arrencarAvio = new ArrencarOrdre(avio);
        Ordre frenarAvio = new FrenarOrdre(avio);

        Invocador invocador = new Invocador();
        invocador.afegirOrdre(frenarBicicleta);
        invocador.afegirOrdre(arrencarAvio);
        invocador.afegirOrdre(frenarAvio);

        invocador.executarOrdres();
    }
}
