package tasca4.n1exercici2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoDniTest {

    @ParameterizedTest(name = "DNI {0}: Lletra esperada {1}")
    @CsvSource({
            "12345678, Z",
            "36525179, Y",
            "56789012, B",
            "34567890, V",
            "11223344, B",
            "44556677, L",
            "99988877, B",
            "11122233, P",
            "77777777, B",
            "88888888, Y"
    })
    public void testCalculoDni(int dni, char lletraEsperada) {
        CalculoDni calculoDni = new CalculoDni(dni);
        char lletraCalculada = calculoDni.getLletra();

        assertEquals(lletraEsperada, lletraCalculada, "La lletra calculada no coincideix amb l'esperada per al DNI " + dni);
    }

}
