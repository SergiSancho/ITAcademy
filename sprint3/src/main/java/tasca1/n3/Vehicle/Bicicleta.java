package tasca1.n3.Vehicle;

public class Bicicleta extends Vehicle {

    @Override
    public void arrencar() {
        System.out.println("La bici arrenca");
    }

    @Override
    public void accelerar() {
        System.out.println("La bici accelera");
    }

    @Override
    public void frenar() {
        System.out.println("La bici intenta frenar");
    }
}
