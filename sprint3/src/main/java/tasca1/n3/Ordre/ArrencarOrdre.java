package tasca1.n3.Ordre;

import tasca1.n3.Vehicle.Vehicle;

public class ArrencarOrdre implements Ordre{

    private Vehicle vehicle;

    public ArrencarOrdre(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void executar() {
        vehicle.arrencar();
    }
}
