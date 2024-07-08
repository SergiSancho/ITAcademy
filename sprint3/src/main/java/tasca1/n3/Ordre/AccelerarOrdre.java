package tasca1.n3.Ordre;

import tasca1.n3.Vehicle.Vehicle;

public class AccelerarOrdre implements Ordre {

    private Vehicle vehicle;

    public AccelerarOrdre(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void executar() {
        vehicle.accelerar();
    }
}
