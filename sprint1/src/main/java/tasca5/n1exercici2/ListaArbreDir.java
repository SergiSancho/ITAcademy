package tasca5.n1exercici2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ListaArbreDir {

    private static String indentacio = "";

    public static void listarArbreDirectori(String ruta) {
        File dir = new File(ruta);

        if (!dir.isDirectory()) {
            System.out.println("Aixo no es un directori");
            return;
        }

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
            System.out.println(indentacio + tipus + " " +
                    arxiu.getName() + " Última modificació: " +
                    sdf.format(arxiu.lastModified()));
            if (arxiu.isDirectory()) {
                indentacio += "   ";
                listarArbreDirectori(arxiu.getPath());
                indentacio = indentacio.substring(0, indentacio.length() - 3);
            }
        }
    }
}
