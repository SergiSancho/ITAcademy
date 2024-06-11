package tasca1.n2exercici1;

import tasca1.n2exercici1.herencia.*;

public class Main {

    public static void main(String[] args) {

        Smartphone smartphone = new Smartphone("Apple", "iphone 6");

        smartphone.trucar("666996699");
        smartphone.alarma();
        smartphone.fotografiar();
    }
}
