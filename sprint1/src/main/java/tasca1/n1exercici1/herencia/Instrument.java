package tasca1.n1exercici1.herencia;

public abstract class Instrument {

    protected String nom;
    protected double preu;

    public Instrument(String nom, double preu) {

        this.nom = nom;
        this.preu = preu;
    }

    public abstract void tocar();

}
