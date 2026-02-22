import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarPhaseTest {
    @Test
    void testConstructorAndGetters() {
        WarPhase wp = new WarPhase(1, "Preparation", "Setup phase", false, false);
        assertEquals(1, wp.getPhaseNumber());
        assertEquals("Preparation", wp.getPhaseName());
        assertEquals("Setup phase", wp.getDescription());
        assertFalse(wp.isWeaponsUnlocked());
        assertFalse(wp.isVehiclesUnlocked());
    }

    @Test
    void testSetters() {
        WarPhase wp = new WarPhase(1, "Preparation", "Setup phase", false, false);
        wp.setPhaseNumber(2);
        wp.setPhaseName("Battle");
        wp.setDescription("Combat phase");
        wp.setWeaponsUnlocked(true);
        wp.setVehiclesUnlocked(true);
        assertEquals(2, wp.getPhaseNumber());
        assertEquals("Battle", wp.getPhaseName());
        assertEquals("Combat phase", wp.getDescription());
        assertTrue(wp.isWeaponsUnlocked());
        assertTrue(wp.isVehiclesUnlocked());
    }

    @Test
    void testToString() {
        WarPhase wp = new WarPhase(1, "Preparation", "Setup phase", false, false);
        String str = wp.toString();
        assertTrue(str.contains("Preparation"));
        assertTrue(str.contains("Setup phase"));
        assertTrue(str.contains("false"));
    }
}
