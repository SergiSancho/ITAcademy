package tasca3.n1exercici3;


import java.io.*;
import java.util.*;

public class GestorFitxers {
    private static final String FITXER_PAISOS = "/countries.txt";
    private static final String FITXER_PUNTUACIO = "/classificacio.txt";

    public Map<String, String> carregarPaisosICapitals() {
        Map<String, String> mapaPaisCapital = new HashMap<>();

        try (InputStream inputStream = getClass().getResourceAsStream(FITXER_PAISOS);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            if (inputStream == null) {
                throw new FileNotFoundException("No s'ha trobat el fitxer: " + FITXER_PAISOS);
            }

            String linia;
            while ((linia = br.readLine()) != null) {
                String[] parts = linia.split(" ", 2);
                if (parts.length == 2) {
                    mapaPaisCapital.put(parts[0].trim(), parts[1].trim().replace("_", " "));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapaPaisCapital;
    }

    public void desarPuntuacio(String nomUsuari, int puntuacio) {

        String filePath = System.getProperty("user.dir" ) + "\\sprint1\\src\\main\\resources" + FITXER_PUNTUACIO;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(nomUsuari + ": " + puntuacio + " punts\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
