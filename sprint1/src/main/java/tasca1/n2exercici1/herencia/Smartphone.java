package tasca1.n2exercici1.herencia;

import tasca1.n2exercici1.interficies.*;

public class Smartphone extends Telefon implements Camera, Rellotge {

    public Smartphone(String marca, String model) {
        super(marca, model);

    }

    public void alarma() {

        System.out.println("S'està fent una foto");
    }

    public void fotografiar() {

        System.out.println("Està sonant l'alarma");
    }
}
