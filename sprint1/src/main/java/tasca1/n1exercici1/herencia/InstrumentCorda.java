package tasca1.n1exercici1.herencia;

public class InstrumentCorda extends Instrument {

    public InstrumentCorda(String nom, double preu) {
        super(nom, preu);

    }


    public void tocar() {

        System.out.println("Està sonant un instrument de corda");

    }

    // Atribut estàtic
    public static int id = 1;

    // Bloc estàtic
    static {
        System.out.println("Bloc estàtic només s'executa un cop. La classe InstrumentCorda es carrega a la memòria");
    }

    // Bloc d'inicilització
    {
        System.out.println("Bloc d'inicialització, s'executa cada cop que fem una instància InstrumentCorda");
    }

}
