package n3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ConvertidorMoneda convertidorMoneda = new ConvertidorMonedaImpl();

        List<Producte> productes = new ArrayList<>();
        productes.add(new Producte("Sabatilles", 100)); // EUR
        productes.add(new Producte("Samarreta", 25)); // EUR
        productes.add(new Producte("Pantalons", 80)); // EUR

        MostrarProducte mostrador = new MostrarProducte(convertidorMoneda);

        mostrador.mostrarPreus(productes, "USD");
        mostrador.mostrarPreus(productes, "GBP");
        mostrador.mostrarPreus(productes, "RUB");
    }
}
