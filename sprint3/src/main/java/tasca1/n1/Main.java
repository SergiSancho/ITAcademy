package tasca1.n1;

public class Main {
    public static void main(String[] args) {
        Undo undoInstancia = Undo.getInstancia();
        boolean sortir = false;

        while (!sortir) {
            int opcio = Entrada.menu();

            switch (opcio) {
                case 1:
                    String comando = Entrada.llegirString("Introdueix el comando: ");
                    undoInstancia.afegirComando(comando);
                    break;
                case 2:
                    int index = Entrada.llegirInt("Introdueix l'índex del comando a eliminar: ");
                    undoInstancia.eliminarComando(index);
                    break;
                case 3:
                    System.out.println("Historial de comandes:");
                    undoInstancia.llistarComandes();
                    break;
                case 4:
                    sortir = true;
                    System.out.println("Ciao Bellx");
                    break;
            }
        }
    }
}
