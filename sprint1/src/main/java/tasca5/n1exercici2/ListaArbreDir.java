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
        } else {
            File[] contingut = dir.listFiles();
            if (contingut == null) {
                System.out.println("No es pot llegir el contingut del directori: " + ruta);
            } else {

                Arrays.sort(contingut);

                for (File arxiu : contingut) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                    if (arxiu.isFile()) {
                        System.out.println(indentacio + "[F] " +
                                arxiu.getName() + " Última modificació: " +
                                sdf.format(arxiu.lastModified()));
                    } else {
                        System.out.println(indentacio + "[D] " +
                                arxiu.getName() + " Última modificació: " +
                                sdf.format(arxiu.lastModified()));
                        indentacio += "   ";
                        listarArbreDirectori(arxiu.getPath());
                        indentacio = indentacio.substring(0, indentacio.length() - 3);
                    }
                }
            }
        }
    }
}
