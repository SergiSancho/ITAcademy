package tasca5.n1exercici1;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Has d'introduir una ruta al directori");
        } else {
            ListaDir.listarDirectori(args[0]);
        }
    }
}
