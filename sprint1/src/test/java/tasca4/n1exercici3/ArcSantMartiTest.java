package tasca4.n1exercici3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArcSantMartiTest {
    private ArcSantMarti arcSantMarti = new ArcSantMarti();

    @Test
    public void testGetColorIndexValid() {
        assertEquals("Verd", arcSantMarti.getColor(3));
    }

    @Test
    public void testGetColorIndexOutOfBounds() {
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            arcSantMarti.getColor(10);});
        assertEquals("Index fora dels límits de l'array colors", exception.getMessage());
    }

    /*@Test
    public void testGetColorIndexOutOfBounds() {
        assertNull(arcSantMarti.getColor(10));
    }*/
}
