package tasca1.n1exercici1.herencia;

public class InstrumentVent extends Instrument {
    public static int atributoEstatico = 1;

    public InstrumentVent(String nom, double preu) {
        super(nom, preu);

    }

    public void tocar() {

        System.out.println("Està sonant un instrument de vent");

    }
    public static int id = 1;

    static {
        System.out.println("Bloc estàtic només s'executa un cop. La classe InstrumentVent es carrega a la memòria");
    }

    {
        System.out.println("Bloc d'inicialització, s'executa cada cop que fem una instància InstrumentVent");
    }

}