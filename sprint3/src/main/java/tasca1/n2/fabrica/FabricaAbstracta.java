package tasca1.n2.fabrica;

import tasca1.n2.adreca.Adreca;
import tasca1.n2.telefon.Telefon;

public interface FabricaAbstracta {

    Adreca crearAdreca(String carrer, String numero, String codiPostal, String ciutat);

    Telefon crearTelefon(String numeroTelefon);
}
