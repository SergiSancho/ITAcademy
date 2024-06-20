package tasca7.n1exercici1;

import tasca7.n1exercici1.herencia.*;

public class Main {
    public static void main(String[] args) {
        Treballador desdeCasita = new TreballadorOnline("Sergio", "Sancho", 100);
        Treballador enOficina = new TreballadorPresencial("Antonhy", "Perez", 100);
        Treballador quienSabeDonde = new Treballador("John", "Carpenter", 100);

        System.out.println("Sou desdeCasita: " + desdeCasita.calcularSou(100));
        System.out.println("Sou enOficina: " + enOficina.calcularSou(100));
        System.out.println("Sou quienSabeDonde: " + quienSabeDonde.calcularSou(100));
    }





}
