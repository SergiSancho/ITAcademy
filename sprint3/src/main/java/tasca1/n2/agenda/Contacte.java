package tasca1.n2.agenda;

import tasca1.n2.adreca.Adreca;
import tasca1.n2.telefon.Telefon;

public class Contacte {

    private String nom;
    private Adreca adreca;
    private Telefon telefon;

    public Contacte(String nom, Adreca adreca, Telefon telefon) {
        this.nom = nom;
        this.adreca = adreca;
        this.telefon = telefon;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adreca getAdrecaContacte() {
        return adreca;
    }

    public void setAdreca(Adreca adreca) {
        this.adreca = adreca;
    }

    public Telefon getTelefonContacte() {
        return telefon;
    }

    public void setTelefon(Telefon telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "{" +
                "nom='" + nom + '\'' +
                ", adreca=" + adreca +
                ", telefon=" + telefon +
                '}';
    }
}
