package tasca5.n1exercici5;


public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona("Luther", "Blisset", 54);
        String rutaArxiu = "persona.ser";

        Serialitzacio.serialitzarObjecte(persona1, rutaArxiu);
        Serialitzacio.deserialitzarObjecte(rutaArxiu);
    }
}
