package tasca1.n2.adreca;

public class AdrecaEspanya implements Adreca {

    private static final String PAIS = "Espanya";
    private static final String CODI_PAIS = "ES";
    private String carrer;
    private String numero;
    private String codiPostal;
    private String ciutat;

    public AdrecaEspanya(String carrer, String numero, String codiPostal, String ciutat) {
        this.carrer = carrer;
        this.numero = numero;
        this.codiPostal = codiPostal;
        this.ciutat = ciutat;

    }

    @Override
    public String getAdreca() {
        return CODI_PAIS + " " + PAIS + " " + carrer + " " + numero + ", " + codiPostal + " " + ciutat;
    }

    @Override
    public void setAdreca(String carrer, String numero, String codiPostal, String ciutat) {
        this.carrer = carrer;
        this.numero = numero;
        this.codiPostal = codiPostal;
        this.ciutat = ciutat;
    }

    @Override
    public String toString() {
        return "{" +
                "carrer='" + carrer + '\'' +
                ", numero='" + numero + '\'' +
                ", codiPostal='" + codiPostal + '\'' +
                ", ciutat='" + ciutat + '\'' +
                '}';
    }
}
