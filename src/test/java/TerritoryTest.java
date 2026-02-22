import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TerritoryTest {
    @Test
    void testConstructorAndGetters() {
        Territory t = new Territory("Central", 10, 20, "Plains", "Red Legion");
        assertEquals("Central", t.getName());
        assertEquals(10, t.getXCoordinate());
        assertEquals(20, t.getYCoordinate());
        assertEquals("Plains", t.getTerrainType());
        assertEquals("Red Legion", t.getOwnerTeam());
    }

    @Test
    void testSetters() {
        Territory t = new Territory("Central", 10, 20, "Plains", "Red Legion");
        t.setName("East");
        t.setXCoordinate(15);
        t.setYCoordinate(25);
        t.setTerrainType("Forest");
        t.setOwnerTeam("Blue Brigade");
        assertEquals("East", t.getName());
        assertEquals(15, t.getXCoordinate());
        assertEquals(25, t.getYCoordinate());
        assertEquals("Forest", t.getTerrainType());
        assertEquals("Blue Brigade", t.getOwnerTeam());
    }

    @Test
    void testToString() {
        Territory t = new Territory("Central", 10, 20, "Plains", "Red Legion");
        String str = t.toString();
        assertTrue(str.contains("Central"));
        assertTrue(str.contains("10"));
        assertTrue(str.contains("20"));
        assertTrue(str.contains("Plains"));
        assertTrue(str.contains("Red Legion"));
    }
}

