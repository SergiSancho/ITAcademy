package n2.pagament;

public class Paypal implements MetodePagament{

    private final String usuariPaypal;

    public Paypal(String usuariPaypal) {
        this.usuariPaypal = usuariPaypal;
    }

    @Override
    public void pagar(double preu) {
        System.out.println("Pagament per Paypal " + usuariPaypal + ": " + preu + "€");

    }
}
