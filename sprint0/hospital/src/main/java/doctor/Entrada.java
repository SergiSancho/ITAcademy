package doctor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
    private static final Scanner scan = new Scanner(System.in);
    private static final int MINIM = 1;
    private static final int MAXIM = 6;

    public static int menu() {
        int opcio;
        do {
            System.out.println("\nBIENVENIDA A LA GESTION DEL HOSPITAL");
            System.out.println("1. Dar de alta un paciente");
            System.out.println("2. Asignar una cita a un paciente");
            System.out.println("3. Anula una cita a un paciente");
            System.out.println("4. Consultar las citas de un paciente");
            System.out.println("5. Consultar las citas de un médico");
            System.out.println("6. Salir\n");

            opcio = llegirInt("Introduce un número para la opción: ");
            if (opcio < MINIM || opcio > MAXIM) {
                System.out.println("Escoje una opción válida (1 a 6)");
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
                System.out.println("Error de formato. Introduce un dato de tipo int");
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
                    throw new Exception("No se puede introducir una cadena vacía");
                }
                dadaCorrecta = true;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return valorEntrada;
    }
}
