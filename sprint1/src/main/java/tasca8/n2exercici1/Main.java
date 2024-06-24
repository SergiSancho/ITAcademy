package tasca8.n2exercici1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Aki", "Dario", "David", "George A.", "Ang", "Akira", "Ridley");

        System.out.println(nomA3Lletres(noms));
    }

    public static List<String> nomA3Lletres (List<String> noms){
        return noms.stream()
                .filter(nom -> nom.startsWith("A") && nom.length() == 3)
                .toList();
    }
}
