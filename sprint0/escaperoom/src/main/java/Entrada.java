
import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
    private static final Scanner scan = new Scanner(System.in);
    private static final int MINIM = 1;
    private static final int MAXIM = 6;

    public static int menu() {
        int opcio;
        do {
            System.out.println("\nBIENVENIDA A LA GESTION DE ESCAPE ROOM VIRTUAL");
            System.out.println("1. Crear una nueva sala.");
            System.out.println("2. Añadir pistas a una sala específica.");
            System.out.println("3. Introducir objetos de decoración para ambientar las salas.");
            System.out.println("4. Mostrar el inventario actualizado, incluyendo cantidades disponibles y valor total.");
            System.out.println("5. Permitir la retirada de elementos del inventario.");
            System.out.println("6. Salir\n");

            opcio = llegirInt("Introduce un número para la opción: ");
            if (opcio < MINIM || opcio > MAXIM) {
                System.out.println("Escoje una opción válida (1 a 6)");
            }
        } while (opcio < MINIM || opcio > MAXIM);
        return opcio;
    }

    public static double llegirDouble(String missatge) {
        double valorEntrada = 0.0;
        boolean dadaCorrecta = false;

        while (!dadaCorrecta) {
            try {
                System.out.println(missatge);
                valorEntrada = scan.nextDouble();
                dadaCorrecta = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de formato. Introduce un dato de tipo double");
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
