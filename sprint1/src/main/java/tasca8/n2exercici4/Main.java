package tasca8.n2exercici4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> potiPoti = Arrays.asList("Wu Ming", "007", "Shanty town", 54, "Blisset", "Q", 451, "Farenheit", 1312,
                "5446", "That's my number", 1984, "Anarres", "Eric Arthur Blair");

        List<Object> ordenatPerPrimerCar = potiPoti.stream()
                .sorted((e1, e2) -> {
                    boolean e1EsCadena = e1 instanceof String;
                    boolean e2EsCadena = e2 instanceof String;

                    if (e1EsCadena && e2EsCadena) {
                        String str1 = (String) e1;
                        String str2 = (String) e2;
                        return Character.compare(Character.toLowerCase(str1.charAt(0)), Character.toLowerCase(str2.charAt(0)));
                    } else if (e1EsCadena) {
                        return -1;
                    } else if (e2EsCadena) {
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .toList();

        System.out.println("Ordenat alfabèticament pel primer caràcter, amb números al final: " + ordenatPerPrimerCar);


        List<Object> ordenatPerE = potiPoti.stream()
                .filter(e -> e instanceof String && ((String) e).contains("e"))
                .sorted(Comparator.comparingInt(e -> Character.toLowerCase(((String) e).charAt(0))))
                .toList();
        System.out.println("Les cadenes amb 'e' primer: " + ordenatPerE);

        List<Object> llistaModificada = potiPoti.stream()
                .map(e -> {
                    if (e instanceof String) {
                        return ((String) e).replace("a", "4").replace("A", "4");
                    }
                    return e;
                })
                .toList();

        System.out.println("Llista amb 'a' reemplaçat per '4': " + llistaModificada);

        List<Object> elementsNumerics = potiPoti.stream()
                .filter(e -> e instanceof Integer || (e instanceof String && ((String) e).chars().allMatch(Character::isDigit)))
                .toList();

        System.out.println("Elements numèrics: " + elementsNumerics);
    }
}