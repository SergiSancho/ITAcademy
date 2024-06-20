package tasca7.n2exercici1;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Luther", "Blisset",54);

        try {
            JsonSerializable jsonAnotacio = persona.getClass().getAnnotation(JsonSerializable.class);
            String directori = System.getProperty("user.dir") + File.separator;
            String arxiu = directori + "persona.json";
            Gson gson = new Gson();
            String jsonString = gson.toJson(persona);

            try (FileWriter write = new FileWriter(arxiu)){

                write.write(jsonString);
                System.out.println("Objecte serialitzat a " + arxiu);
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (SecurityException e){
            e.printStackTrace();
        }
    }
}
