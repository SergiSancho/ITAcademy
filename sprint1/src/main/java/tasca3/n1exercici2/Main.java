package tasca3.n1exercici2;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> llista = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            llista.add(i);
        }

        List<Integer> llista2 = new ArrayList<>();

        ListIterator<Integer> li = llista.listIterator(llista.size());

        while(li.hasPrevious()){
            llista2.add(li.previous());
        }

        System.out.println("Llista 1: " + llista);
        System.out.println("Llista 2: " + llista2);
    }
}
