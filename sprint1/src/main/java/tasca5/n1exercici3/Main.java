package tasca5.n1exercici3;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("Has d'introduir dos paràmetres: ");
            System.out.println("1. Ruta del directori a llistar");
            System.out.println("2. Ruta del fitxer on vols escriure la llista");
            return;
        }
        EscriuArbreDir.writerArbreDir(args[0], args[1]);
    }
}
