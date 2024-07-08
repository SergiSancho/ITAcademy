package tasca1.n3.Vehicle;

public class Vaixell extends Vehicle {

    @Override
    public void arrencar() {
        System.out.println("El vaixell està arrencant");
    }

    @Override
    public void accelerar() {
        System.out.println("El vaixell està accelerant");
    }

    @Override
    public void frenar() {
        System.out.println("El vaixell frena. Que fa un vaixell en un parking?");
    }
}
