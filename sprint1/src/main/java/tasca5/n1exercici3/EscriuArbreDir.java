package tasca5.n1exercici3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class EscriuArbreDir {
    private static String indentacio = "";

   public static void writerArbreDir(String ruta, String rutaArxiu) {
        File dir = new File(ruta);

        if (!dir.isDirectory()) {
            System.out.println("Aixo no es un directori");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArxiu, true))) {
            File[] contingut = dir.listFiles();
            Arrays.sort(contingut);

            for (File arxiu : contingut) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String tipus;
                if (arxiu.isDirectory()) {
                    tipus = "D";
                } else {
                    tipus = "F";
                }
                writer.write(indentacio + tipus + " " +
                        arxiu.getName() + " Última modificació: " +
                        sdf.format(arxiu.lastModified()) + "\n");
                if (arxiu.isDirectory()) {
                    indentacio += "   ";
                    writerArbreDir(arxiu.getPath(), rutaArxiu);
                    indentacio = indentacio.substring(0, indentacio.length() - 3);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}