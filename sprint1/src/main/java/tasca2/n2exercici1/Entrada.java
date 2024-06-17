package tasca2.n2exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

    private static final Scanner scan = new Scanner(System.in);

    public static byte llegirByte(String missatge) {
        byte valorEntrada = 0;
        boolean dadaCorrecta = false;

        while (!dadaCorrecta) {
            try {
                System.out.println(missatge);
                valorEntrada = scan.nextByte();
                dadaCorrecta = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. Introdueix una dada de tipus byte");
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

    public static float llegirFloat(String missatge) {
        float valorEntrada = 0.0f;
        boolean dadaCorrecta = false;

        while (!dadaCorrecta) {
            try {
                System.out.println(missatge);
                valorEntrada = scan.nextFloat();
                dadaCorrecta = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. Introdueix una dada de tipus float");
                scan.nextLine();
            }
        }
        scan.nextLine();
        return valorEntrada;
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
                System.out.println("Error de format. Introdueix una dada de tipus double");
                scan.nextLine();
            }
        }
        scan.nextLine();
        return valorEntrada;
    }

    public static char llegirChar(String missatge) {
        String valorEntrada;
        boolean dadaCorrecta = false;
        char valorEntradaChar = ' ';

        while (!dadaCorrecta) {
            try {
                System.out.println(missatge);
                valorEntrada = scan.nextLine();
                if (valorEntrada.length() != 1) {
                    throw new Exception("Només s'accepta un caràcter");
                }
                valorEntradaChar = valorEntrada.charAt(0);
                dadaCorrecta = true;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scan.nextLine();
            }
        }
        return valorEntradaChar;
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

    public static boolean llegirSiNo(String missatge) {
        while (true) {
            try {
                System.out.println(missatge + " (s/n)");
                String valorEntrada = scan.nextLine();
                if (valorEntrada.equalsIgnoreCase("s")) {
                    return true;
                } else if (valorEntrada.equalsIgnoreCase("n")) {
                    return false;
                } else {
                    throw new Exception("Resposta no vàlida. Introdueix 's' o 'n'.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}



