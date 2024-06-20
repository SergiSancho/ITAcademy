package tasca7.n1exercici1.herencia;

public class Treballador {

    protected String nom;
    protected String cognom;
    protected double preuHora;

    public Treballador(String nom, String cognom, double preuHora) {
        this.nom = nom;
        this.cognom = cognom;
        this.preuHora = preuHora;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public double getPreuHora() {
        return preuHora;
    }

    public void setPreuHora(double preuHora) {
        this.preuHora = preuHora;
    }

    public double calcularSou(double horesTreballades){

        return horesTreballades * preuHora;
    }

    @Override
    public String toString() {
        return "Treballador{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", preuHora=" + preuHora +
                '}';
    }
}
