package tasca1.n3.Ordre;

import tasca1.n3.Vehicle.Vehicle;

public class FrenarOrdre implements Ordre{

    private Vehicle vehicle;

    public FrenarOrdre(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void executar() {
        vehicle.frenar();
    }
}
