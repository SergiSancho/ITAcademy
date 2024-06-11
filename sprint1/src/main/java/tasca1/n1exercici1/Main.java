package tasca1.n1exercici1;

import tasca1.n1exercici1.herencia.*;

public class Main {

    public static void main (String[] args) {

        System.out.println("Fem una primera instància d'InstrumentCorda. S'executen els blocs estàtic i d'inicialització:");
        InstrumentCorda guitarra = new InstrumentCorda("guitarra", 100);

        System.out.println("A la segona instància d'InstrumentCorda, ja només s'executa el bloc d'inicialització:");
        InstrumentCorda guitarra2 = new InstrumentCorda("guitarra2", 200);

        System.out.println("Fem la càrrega al accedir a un atribut estàtic de InstrumentVent:");
        InstrumentVent.id++;
        System.out.println("Si fem una primera instància d'InstrumentVent, ja només s'executa el bloc d'inicialització:");
        InstrumentVent trompeta = new InstrumentVent("trompeta", 300);

        guitarra.tocar();
        trompeta.tocar();

    }

}
