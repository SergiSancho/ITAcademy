package tasca1.n2;

import tasca1.n2.agenda.*;

public class Main {
    public static void main(String[] args) {
        inici();
    }

    private static void inici() {
        Agenda agenda = new Agenda();
        boolean sortir = false;

        while (!sortir) {
            int opcio = Entrada.menu();

            switch (opcio) {
                case 1:
                    agenda.afegirContacte();
                    break;
                case 2:
                    agenda.eliminarContacte();
                    break;
                case 3:
                    agenda.llistarContactes();
                    break;
                case 4:
                    System.out.println("Ciao bellx...");
                    sortir = true;
                    break;
            }
        }
    }
}
