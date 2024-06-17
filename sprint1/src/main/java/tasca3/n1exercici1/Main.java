package tasca3.n1exercici1;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Month> mesos = new ArrayList<>();

        mesos.add(new Month("Gener"));
        mesos.add(new Month("Febrer"));
        mesos.add(new Month("Març"));
        mesos.add(new Month("Abril"));
        mesos.add(new Month("Maig"));
        mesos.add(new Month("Juny"));
        mesos.add(new Month("Juliol"));
        mesos.add(new Month("Setembre"));
        mesos.add(new Month("Octubre"));
        mesos.add(new Month("Novembre"));
        mesos.add(new Month("Desembre"));

        mesos.add(7, new Month("Agost"));

        System.out.println("Mesos ordenats a l'arrayList:");

        for (Month mes : mesos) {
            System.out.println(mes.getName());
        }

        HashSet<Month> mesosSet = new HashSet<>(mesos);

        mesosSet.add(new Month("Agost"));
        mesosSet.add(new Month("Juny"));
        mesosSet.add(new Month("Juliol"));

        System.out.println("HashSet (no admet duplicats) recorregut amb bucle for:");
        for (Month mes : mesosSet) {
            System.out.println(mes.getName());
        }

        System.out.println("HashSet recorregut amb iterador:");
        Iterator<Month> it = mesosSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
