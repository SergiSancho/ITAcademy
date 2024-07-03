package tasca8.n2exercici4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> potiPoti = Arrays.asList("Wu Ming", "007", "Shanty town", "54", "Blisset", "Q", "451", "Farenheit", "1312",
                "5446", "That's my number", "1984", "Anarres", "Eric Arthur Blair");

        System.out.println("Ordenats pel primer caràcter");
        potiPoti.sort(Comparator.comparingInt(s -> s.toLowerCase().charAt(0)));
        System.out.println(potiPoti);

        potiPoti.sort(Comparator.comparing((String s)->
                !s.toUpperCase().contains("E")).thenComparing((String s)->s.toUpperCase()));
        System.out.println(potiPoti);

        System.out.println("Modifica la a per un 4");
        potiPoti.replaceAll(s->s.replace("a", "4"));
        System.out.println(potiPoti);

        System.out.println("Mostra només elements numèrics");
        System.out.println(potiPoti.stream().filter(s->s.matches("\\d+")).collect(Collectors.joining(",")));


    }
}