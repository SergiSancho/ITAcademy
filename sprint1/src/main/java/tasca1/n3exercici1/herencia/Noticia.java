package tasca1.n3exercici1.herencia;

public abstract class Noticia {
    protected String titular;
    protected String text;
    protected int puntuacio;
    protected int preu;

    public Noticia(String titular) {

        this.titular = titular;
        this.text = "";
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public int getPreu() {
        return preu;
    }

    public abstract void calcularPreu();

    public abstract void calcularPuntuacio();

    public String toString() {
        return "Noticia [titular=" + titular + ", text=" + text + ", puntuacio=" + puntuacio + ", preu=" + preu + "]";
    }
}
