package tasca1.n3.Vehicle;

public class Cotxe extends Vehicle{

    @Override
    public void arrencar() {
        System.out.println("El cotxe està arrencant");
    }

    @Override
    public void accelerar() {
        System.out.println("El cotxe està accelerant");
    }

    @Override
    public void frenar() {
        System.out.println("El cotxe està frenant");
    }
}
