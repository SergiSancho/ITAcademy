package tasca3.n2exercici2;

import java.util.Objects;

public class Restaurant implements Comparable<Restaurant> {

    private String nom;
    private int puntuacio;

    public Restaurant(String nom, int puntuacio) {
        this.nom = nom;
        this.puntuacio = puntuacio;
    }

    public String getNom() {
        return nom;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return puntuacio == that.puntuacio && Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, puntuacio);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "nom='" + nom + '\'' +
                ", puntuacio=" + puntuacio +
                '}';
    }

    @Override
    public int compareTo(Restaurant otro) {
        int resultado = this.nom.compareTo(otro.getNom());
        if(resultado == 0){
            resultado = Integer.compare(otro.getPuntuacio(), this.puntuacio);
        }
        return resultado;
    }
}

