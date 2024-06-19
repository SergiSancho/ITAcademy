package tasca5.n1exercici1;

import java.io.File;
import java.util.Arrays;

public class ListaDir {
    public static void listarDirectori(String ruta){
        File dir = new File(ruta);

        if(!dir.isDirectory()){
            System.out.println("Aixo no es un directori");
            return;
        }

        String[] contingut = dir.list();
        Arrays.sort(contingut);
        System.out.println("Contingut de: " + dir + ":");
        for (String arxiu : contingut) {
            System.out.println(arxiu);
        }
    }
}
