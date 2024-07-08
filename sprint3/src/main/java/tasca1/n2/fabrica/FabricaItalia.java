package tasca1.n2.fabrica;

import tasca1.n2.adreca.Adreca;
import tasca1.n2.adreca.AdrecaItalia;
import tasca1.n2.telefon.Telefon;
import tasca1.n2.telefon.TelefonItalia;

public class FabricaItalia implements FabricaAbstracta{
    @Override
    public Adreca crearAdreca(String carrer, String numero, String codiPostal, String ciutat) {
        return new AdrecaItalia(carrer, numero, codiPostal, ciutat);
    }

    @Override
    public Telefon crearTelefon(String numeroTelefon) {
        return new TelefonItalia(numeroTelefon);
    }
}
