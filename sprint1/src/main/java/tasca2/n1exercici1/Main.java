package tasca2.n1exercici1;

public class Main {

    public static void main (String[] args){

        Producte producte1 = new Producte("Camiseta", 10);
        Producte producte2 = new Producte("Pantalón", 30);
        Producte producte3 = new Producte("zapatos", 50);

        Venda venda = new Venda();

        try{
            double preuFinal = venda.calcularTotal();
            System.out.println("El preu final de la venda és: " +  preuFinal);

        }catch (VendaBuidaException e) {

            System.out.println(e.getMessage());
        }

        venda.afegirProducte(producte1);
        venda.afegirProducte(producte2);
        venda.afegirProducte(producte3);

        try{
            double preuFinal = venda.calcularTotal();
            System.out.println("El preu final de la venda és: " +  preuFinal);

        }catch (VendaBuidaException e) {

            System.out.println(e.getMessage());
        }

        try{

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e.getMessage());
        }
    }





}
