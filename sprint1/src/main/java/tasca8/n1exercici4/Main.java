package tasca8.n1exercici4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> mesos = Arrays.asList("Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol",
                "Agost", "Setembre", "Octubre", "Novembre", "Desembre");

        mesos.forEach(System.out::println);
    }
}
