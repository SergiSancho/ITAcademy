package tasca6.n2exercici2;

import tasca6.n1exercici2.Persona;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Luther", "Blisset", 55);

        GenericMethods.printArguments("hola", 54, persona1, persona1, "Q");
    }
}
