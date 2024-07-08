package n2.pagament;

public class CompteBancari implements MetodePagament{

    private final String numeroCompte;

    public CompteBancari(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    @Override
    public void pagar(double preu) {
        System.out.println("Pagament per Compte Bancari " + numeroCompte + ": " + preu + "€");
    }
}
