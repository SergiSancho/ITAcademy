package tasca8.n1exercici2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> directors = Arrays.asList("Carpenter", "Scott", "Cronenberg", "Lynch", "Argento", "Raimi", "Romero",
                "Dante", "Hill", "Malick" );
        var directorsFiltrats = directorsAmbOMes5Lletres(directors);
        System.out.println(directorsFiltrats);
    }

    public static List<String> directorsAmbOMes5Lletres (List<String> directors){
        return directors.stream()
                .filter(director -> director.contains("o") && director.length() > 5)
                .toList();
    }
}
