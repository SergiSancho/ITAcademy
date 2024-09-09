package n3;

import java.util.List;

public class MostrarProducte {

    private final ConvertidorMoneda convertidorMoneda;

    public MostrarProducte(ConvertidorMoneda convertidorMoneda) {
        this.convertidorMoneda = convertidorMoneda;
    }

    public void mostrarPreus(List<Producte> productes, String moneda) {
        System.out.println("Mostrant preus en " + moneda + ":");

        for (Producte producte : productes) {
            double preuConvertit = convertidorMoneda.convertir(producte.getPreu(), moneda);
            System.out.println(producte.getNom() + ": " + preuConvertit + " " + moneda);
        }
    }
}