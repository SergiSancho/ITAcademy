package tasca8.n1exercici1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> directors = Arrays.asList("Carpenter", "Scott", "Cronenberg", "Lynch", "Argento", "Raimi", "Romero",
                "Dante", "Hill", "Malick" );
        var directorsFiltrats = directorsAmbO(directors);
        System.out.println(directorsFiltrats);
    }

    public static List<String> directorsAmbO (List<String> directors){
        return directors.stream()
                .filter(director -> director.contains("o"))
                .toList();
    }
}
