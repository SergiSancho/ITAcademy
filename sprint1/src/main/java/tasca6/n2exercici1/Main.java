package tasca6.n2exercici1;

import tasca6.n1exercici2.Persona;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Luther", "Blisset", 55);

        GenericMethods.printArguments(persona1, 666, "El tercer arg ha de ser un String");
    }
}
