package tasca1.n3exercici1.herencia;

public class NoticiaF1 extends Noticia {

    private String escuderia;

    public NoticiaF1(String titular, String escuderia) {
        super(titular);
        this.escuderia = escuderia;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    @Override
    public void calcularPreu() {
        int preu = 100;
        if (escuderia.equalsIgnoreCase("Ferrari") || escuderia.equalsIgnoreCase("Mercedes")) {
            preu += 50;
        }
        this.preu = preu;
    }

    @Override
    public void calcularPuntuacio() {

        int puntuacio = 4;
        if (escuderia.equalsIgnoreCase("Ferrari") || escuderia.equalsIgnoreCase("Mercedes")) {
            puntuacio += 2;
        }
        this.puntuacio = puntuacio;
    }

    @Override
    public String toString() {
        return "NoticiaF1 [escuderia=" + escuderia + ", titular=" + titular + ", text=" + text + ", puntuacio="
                + puntuacio + ", preu=" + preu + "]";
    }

}
