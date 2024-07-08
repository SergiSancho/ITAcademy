package tasca1.n2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

    private static final Scanner scan = new Scanner(System.in);
    private static final int MINIM = 1;
    private static final int MAXIM = 4;

    public static int menu() {
        int opcio;
        do {
            System.out.println("\nMENÚ PRINCIPAL *** AGENDA només ES IT ***");
            System.out.println("1. Afegir contacte");
            System.out.println("2. Eliminar contacte");
            System.out.println("3. Llistar contactes");
            System.out.println("4. Sortir de l'aplicació\n");

            opcio = tasca1.n1.Entrada.llegirInt("Introdueixi un número per l'opció:");
            if (opcio < MINIM || opcio > MAXIM) {
                System.out.println("Escull una opció vàlida.");
            }
        } while (opcio < MINIM || opcio > MAXIM);
        return opcio;
    }


    public static int llegirInt(String missatge) {
        int valorEntrada = 0;
        boolean dadaCorrecta = false;

        while (!dadaCorrecta) {
            try {
                System.out.println(missatge);
                valorEntrada = scan.nextInt();
                dadaCorrecta = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. Introdueix una dada de tipus int");
                scan.nextLine();
            }
        }
        scan.nextLine();
        return valorEntrada;
    }

    public static String llegirString(String missatge) {
        String valorEntrada = "";
        boolean dadaCorrecta = false;
        while (!dadaCorrecta) {
            try {
                System.out.print(missatge);
                valorEntrada = scan.nextLine();

                if (valorEntrada.isEmpty()) {
                    throw new Exception("No es pot introduir una cadena buida");
                }
                dadaCorrecta = true;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return valorEntrada;
    }
}

