package tasca4.n1exercici1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MesosAnyTest {

    private static MesosAny mesosAny;
    private static List<String> llistaMesos;

    @BeforeAll
    public static void setUp(){
        mesosAny =  new MesosAny();
        llistaMesos = mesosAny.getLlistaMesos();
    }

    @Test
    public void testLlista12posicions(){
        assertEquals(12, llistaMesos.size());
    }

    @Test
    public void testLlistaNoNula(){
        assertNotNull(llistaMesos, "La llista no pot ser nula");
    }

    @Test
    public void testLlistaAgost(){
        assertEquals("Agost", llistaMesos.get(7), "El mes a la posició 8 ha de ser Agost");
    }
}
