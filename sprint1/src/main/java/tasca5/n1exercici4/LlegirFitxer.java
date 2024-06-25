package tasca5.n1exercici4;

import java.io.*;

public class LlegirFitxer {
    public static void readFitxer(String rutaArxiu) {
        File fitxer = new File(rutaArxiu);
        try (BufferedReader br = new BufferedReader(new FileReader(fitxer))) {
            String linia;
            System.out.println("Contingut del fitxer" + fitxer.getName());
            while ((linia = br.readLine()) != null) {
                System.out.println(linia);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
