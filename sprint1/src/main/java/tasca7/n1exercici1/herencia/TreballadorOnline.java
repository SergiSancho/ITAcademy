package tasca7.n1exercici1.herencia;

public class TreballadorOnline extends Treballador{

    private static final double TARIFA_INTERNET = 15.0;

    public TreballadorOnline(String nom, String cognom, double preuHora) {
        super(nom, cognom, preuHora);
    }

    public static double getTarifaInternet(){
        return TARIFA_INTERNET;
    }

    @Override
    public double calcularSou(double horesTreballades) {
        return horesTreballades * preuHora + TARIFA_INTERNET;
    }
}
