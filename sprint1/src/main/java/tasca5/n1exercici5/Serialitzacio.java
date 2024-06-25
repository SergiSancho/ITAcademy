package tasca5.n1exercici5;

import java.io.*;

public class Serialitzacio {

    public static <T extends Serializable> void serialitzarObjecte (T object, String rutaArxiu){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArxiu))) {
            oos.writeObject(object);
            System.out.println("Objecte serialitzat correctament");
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static <T extends Serializable> void deserialitzarObjecte (String rutaArxiu){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArxiu))) {
            T objecte = (T) ois.readObject();
            System.out.println(objecte.toString());
            System.out.println("Objecte deserialitzat correctament");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
