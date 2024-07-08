package tasca1.n2.telefon;

public class TelefonItalia implements Telefon {

    private static final String PREFIXE= "+39";
    private String numeroTelefon;

    public TelefonItalia(String numeroTelefon) {
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
