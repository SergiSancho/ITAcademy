package tasca5.n1exercici4;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Has d'introduir una ruta al fitxer");
            return;
        }
        LlegirFitxer.readFitxer(args[0]);
    }
}
