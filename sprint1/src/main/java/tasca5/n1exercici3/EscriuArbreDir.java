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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArxiu))) {
            writeDirectoryTree(dir, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeDirectoryTree(File dir, BufferedWriter writer) throws IOException {
        File[] contingut = dir.listFiles();
        if (contingut == null) {
            writer.write("No es pot llegir el contingut del directori: " + dir.getPath() + "\n");
            return;
        }

        Arrays.sort(contingut);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        for (File arxiu : contingut) {
            if (arxiu.isFile()) {
                writer.write(indentacio + "[F] " +
                        arxiu.getName() + " Última modificació: " +
                        sdf.format(arxiu.lastModified()) + "\n");
            } else if (arxiu.isDirectory()) {
                writer.write(indentacio + "[D] " +
                        arxiu.getName() + " Última modificació: " +
                        sdf.format(arxiu.lastModified()) + "\n");

                String currentIndentacio = indentacio;
                indentacio += "   ";
                writeDirectoryTree(arxiu, writer);
                indentacio = currentIndentacio;
            }
        }
    }
}