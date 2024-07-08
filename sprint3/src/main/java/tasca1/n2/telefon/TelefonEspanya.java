package tasca1.n2.telefon;

public class TelefonEspanya implements Telefon {

    private static final String PREFIXE = "+34";
    private String numeroTelefon;

    public TelefonEspanya(String numeroTelefon) {
        this.numeroTelefon = numeroTelefon;
    }

    @Override
    public String getTelefon() {
        return PREFIXE + " " + this.numeroTelefon;
    }

    @Override
    public void setTelefon(String numeroTelefon) {
        this.numeroTelefon = numeroTelefon;
    }

    @Override
    public String toString() {
        return "{" +
                "numeroTelefon='" + numeroTelefon + '\'' +
                '}';
    }
}
