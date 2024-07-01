package tasca7.n2exercici1;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Luther", "Blisset", 54);

        try {
            JsonSerializable jsonAnotacio = persona.getClass().getAnnotation(JsonSerializable.class);
            if (jsonAnotacio != null) {
                String directori = jsonAnotacio.directori();
                if (directori.isEmpty()) {
                    directori = System.getProperty("user.dir");
                }
                String arxiu = directori + File.separator + "persona.json";

                Gson gson = new Gson();
                String jsonString = gson.toJson(persona);

                try (FileWriter writer = new FileWriter(arxiu)) {
                    writer.write(jsonString);
                    System.out.println("Objecte serialitzat a " + arxiu);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("L'anotació JsonSerializable no està present.");
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}