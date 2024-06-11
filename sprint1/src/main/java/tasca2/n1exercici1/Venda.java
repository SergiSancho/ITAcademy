package tasca2.n1exercici1;

import java.util.ArrayList;
import java.util.List;


public class Venda {
    public List<Producte> productes;
    public double preuTotal;

    public Venda() {
        this.productes = new ArrayList<>();
        this.preuTotal = 0.0;
    }

    public void afegirProducte(Producte producte){
        this.productes.add(producte);
    }

    public double getPreuTotal() {
        return preuTotal;
    }

    public void setPreuTotal(double preuTotal) {
        this.preuTotal = preuTotal;
    }

    public double calcularTotal() throws VendaBuidaException{

        if(productes.isEmpty()){

            throw new VendaBuidaException();
        }
        preuTotal = 0.0;

        for (Producte producte : productes){

            preuTotal += producte.getPreu();
        }

        return preuTotal;
    }
}
