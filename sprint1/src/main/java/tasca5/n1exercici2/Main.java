package tasca5.n1exercici2;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Has d'introduir una ruta al directori");
            return;
        }

        ListaArbreDir.listarArbreDirectori(args[0]);
    }
}
