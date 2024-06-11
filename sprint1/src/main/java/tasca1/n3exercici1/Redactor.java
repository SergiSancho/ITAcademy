package tasca1.n3exercici1;

import java.util.ArrayList;

import tasca1.n3exercici1.herencia.*;

public class Redactor {

    private final String dni;
    private String nom;
    public static double sou = 1500.00;
    private ArrayList<Noticia> noticies;

    public Redactor(String dni, String nom) {

        this.dni = dni;
        this.nom = nom;
        this.noticies = new ArrayList<Noticia>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static double getSou() {
        return sou;
    }

    public static void setSou(double sou) {
        Redactor.sou = sou;
    }

    public ArrayList<Noticia> getNoticies() {
        return noticies;
    }

    public int getNumNoticies() {
        return noticies.size();
    }

    public void afegirNoticia(Noticia noticia) {
        noticies.add(noticia);
    }

    public void eliminarVol(Noticia noticia) {
        noticies.remove(noticia);
    }

    public String getDni() {
        return dni;
    }

    public String toString() {
        return "Redactor [dni=" + dni + ", nom=" + nom + ", sou=" + sou + ", noticies=" + noticies +"]";
    }
}
