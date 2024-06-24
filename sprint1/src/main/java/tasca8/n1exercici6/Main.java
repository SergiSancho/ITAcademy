package tasca8.n1exercici6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> numerosCadenes = Arrays.asList("cerco", "un", 666, "centro","di", "gravita", 77, "permanente", 68);
        List<String> cadenesOrdenades = numerosCadenes.stream()
                .filter(e -> e instanceof String)
                .map(e -> (String) e)
                //.sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        System.out.println(cadenesOrdenades);
    }
}

