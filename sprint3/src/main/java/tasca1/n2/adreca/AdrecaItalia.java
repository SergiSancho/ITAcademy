package tasca1.n2.adreca;

public class AdrecaItalia implements Adreca {

    private static final String PAIS = "Itàlia";
    private static final String CODI_PAIS = "IT";
    private String carrer;
    private String numero;
    private String ciutat;
    private String codiPostal;

    public AdrecaItalia(String carrer, String numero, String codiPostal, String ciutat) {
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
        this.ciutat = ciutat;
        this.codiPostal = codiPostal;
    }

    @Override
    public String toString() {
        return "{" +
                "carrer='" + carrer + '\'' +
                ", numero='" + numero + '\'' +
                ", ciutat='" + ciutat + '\'' +
                ", codiPostal='" + codiPostal + '\'' +
                '}';
    }
}
