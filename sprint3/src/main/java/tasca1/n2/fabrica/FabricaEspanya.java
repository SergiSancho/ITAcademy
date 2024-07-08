package tasca1.n2.fabrica;

import tasca1.n2.adreca.Adreca;
import tasca1.n2.adreca.AdrecaEspanya;
import tasca1.n2.telefon.Telefon;
import tasca1.n2.telefon.TelefonEspanya;

public class FabricaEspanya implements FabricaAbstracta{
    @Override
    public Adreca crearAdreca(String carrer, String numero, String codiPostal, String ciutat) {
        return new AdrecaEspanya(carrer, numero, codiPostal, ciutat);
    }

    @Override
    public Telefon crearTelefon(String numeroTelefon) {
        return new TelefonEspanya(numeroTelefon);
    }
}
