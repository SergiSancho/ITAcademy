package tasca1.n3.Vehicle;

public class Avio extends Vehicle{

    @Override
    public void arrencar() {
        System.out.println("Sembla que l'avió arrenca");
    }

    @Override
    public void accelerar() {
        System.out.println("L'avió està accelerant, potser s'enlaire");
    }

    @Override
    public void frenar() {
        System.out.println("L'avió està frenant. La questió seria si ha aterrat amb èxit en un parking soterrani?");
    }
}
