package n2.pagament;

public class TargetaCredit implements MetodePagament {

    private final String numeroTargeta;

    public TargetaCredit(String numeroTargeta) {
        this.numeroTargeta = numeroTargeta;
    }

    @Override
    public void pagar(double preu) {
        System.out.println("Pagament amb Targeta credit " + numeroTargeta + ": " + preu + "€");
    }
}
