package n2;

import n2.pagament.*;

public class Sabateria {
    public void realitzarPagament() {

        double preuTotal = UtilsIO.llegirDouble("Introdueix el preu total de les sabatilles: ");
        int opcioPagament;
        boolean sortir = false;


        do {
            opcioPagament = UtilsIO.menu();
            MetodePagament metodePagament = null;

            switch (opcioPagament) {
                case 1:
                    String numTargeta = UtilsIO.llegirString("Introdueix el número de la targeta de crèdit: ");
                    metodePagament = new TargetaCredit(numTargeta);
                    break;
                case 2:
                    String numCompte = UtilsIO.llegirString("Introdueix el número de compte bancari: ");
                    metodePagament = new CompteBancari(numCompte);
                    break;
                case 3:
                    String emailPaypal = UtilsIO.llegirString("Introdueix l'usuari de Paypal: ");
                    metodePagament = new Paypal(emailPaypal);
                    break;
                case 4:
                    System.out.println("Segur que ja ha pagat? Recodi pagar sempre. Fins aviat!");
                    sortir = true;
                    break;
            }
            if (metodePagament != null) {
                PasarelaPagament pasarela = new PasarelaPagament();
                pasarela.procesarPagament(metodePagament, preuTotal);
                System.out.println("Compra realitzada amb èxit.\n");
                System.out.println("Gràcies per la seva compra. Fins aviat!");
            }

        } while (!sortir);
    }
}
