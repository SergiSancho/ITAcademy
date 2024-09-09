package n3;

public class ConvertidorMonedaImpl implements ConvertidorMoneda {

    @Override
    public double convertir(double quantitat, String moneda) {
        return switch (moneda) {
            case "USD" -> quantitat * 1.09;
            case "RUB" -> quantitat * 88.25;
            case "GBP" -> quantitat * 0.88;
            case "EUR" -> quantitat;
            default -> 0.0;
        };
    }
}
