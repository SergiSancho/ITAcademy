package n2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UtilsIO {

    private static final Scanner scan = new Scanner(System.in);
    private static final int MINIM = 1;
    private static final int MAXIM = 4;

    public static int menu() {
        int opcio;
        do {
            System.out.println("\nBENVINGUDA AL PAGAMENT DE LA SABATERIA");
            System.out.println("1. Targeta Crèdit");
            System.out.println("2. Compte Bancari");
            System.out.println("3. Paypal");
            System.out.println("4. Sortir\n");

            opcio = llegirInt("Introdueixi un número per l'opció de pagament: ");
            if (opcio < MINIM || opcio > MAXIM) {
                System.out.println("Escull una opció vàlida. Pagui d'una vegada, si us plau.");
            }
        } while (opcio < MINIM || opcio > MAXIM);
        return opcio;
    }

    public static double llegirDouble(String missatge) {
        double valorEntrada = 0;
        boolean dadaCorrecta = false;

        while (!dadaCorrecta) {
            try {
                System.out.println(missatge);
                valorEntrada = scan.nextDouble();
                dadaCorrecta = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. Introdueix una dada de tipus double");
                scan.nextLine();
            }
        }
        scan.nextLine();
        return valorEntrada;
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
