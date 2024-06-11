package tasca1.n3exercici1.herencia;

public class NoticiaTenis extends Noticia {
    private String competicio;
    private String tenista;

    public NoticiaTenis(String titular, String competicio, String tenista) {
        super(titular);
        this.competicio = competicio;
        this.tenista = tenista;
    }

    public String getCompeticio() {
        return competicio;
    }

    public void setCompeticio(String competicio) {
        this.competicio = competicio;
    }

    public String getTenista() {
        return tenista;
    }

    public void setTenista(String tenista) {
        this.tenista = tenista;
    }

    public void calcularPreu() {
        int preu = 150;
        if (tenista.equalsIgnoreCase("Federer") || tenista.equalsIgnoreCase("Nadal")
                || tenista.equalsIgnoreCase("Djokovic")) {
            preu += 100;
        }
        this.preu = preu;
    }

    public void calcularPuntuacio() {
        int puntuacio = 4;
        if (tenista.equalsIgnoreCase("Federer") || tenista.equalsIgnoreCase("Nadal")
                || tenista.equalsIgnoreCase("Djokovic")) {
            puntuacio += 3;
        }
        this.puntuacio = puntuacio;
    }

    public String toString() {
        return "NoticiaTenis [competicio=" + competicio + ", tenista=" + tenista + ", titular=" + titular + ", text="
                + text + ", puntuacio=" + puntuacio + ", preu=" + preu + "]";
    }

}

