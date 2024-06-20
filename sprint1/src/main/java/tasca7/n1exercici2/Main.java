package tasca7.n1exercici2;

import tasca7.n1exercici2.herencia.*;

@SuppressWarnings("deprecation")
public class Main {
    public static void main(String[] args) {
        TreballadorOnline desdeCasita = new TreballadorOnline("Sergio", "Sancho", 100);
        TreballadorPresencial enOficina = new TreballadorPresencial("Antonhy", "Perez", 100);
        Treballador quienSabeDonde = new Treballador("John", "Carpenter", 100);

        System.out.println("Sou desdeCasita: " + desdeCasita.calcularSou(100));
        System.out.println("Sou enOficina: " + enOficina.calcularSou(100));
        System.out.println("Sou quienSabeDonde: " + quienSabeDonde.calcularSou(100));

        System.out.println("Paga extra per desdeCasita: " + desdeCasita.pagaExtra());
        System.out.println("Dies de vacances enOficina: " + enOficina.vacances());
    }
}
