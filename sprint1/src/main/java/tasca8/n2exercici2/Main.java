package tasca8.n2exercici2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Integer> enteros = Arrays.asList(1, 2, 3, 4);
        System.out.println(EOEnteros(enteros));
    }

    public static String EOEnteros (List<Integer> enteros){
        return enteros.stream()
                .map(n -> (n % 2 == 0 ? "e" : "o") + n)
                .collect(Collectors.joining(", "));
    }
}
