import java.util.ArrayList;

public class TestInheritInterface {
    public static void main(String[] args) {
        System.out.println("--- Testing Class Hierarchy (Inheritance) ---");
        testClassHierarchy();
        System.out.println("\n--- Testing Interface Implementation ---");
        testInterface();
    }

    public static void testClassHierarchy() {
        ArrayList<Unit> units = new ArrayList<>();
        units.add(new Soldier("Alpha", 100, "Rifle"));
        units.add(new Soldier("Bravo", 90, "SMG"));
        units.add(new Medic("Charlie", 80, 3));
        units.add(new Medic("Delta", 85, 5));

        for (Unit u : units) {
            System.out.println(u.getRoleDescription());
            u.performSpecialAction();
        }
    }

    public static void testInterface() {
        ArrayList<Actionable> actionables = new ArrayList<>();
        actionables.add(new Player("Alex", "Builder", 250, 3, true));
        actionables.add(new Territory("Central Plains", 10, 20, "Grassland", "Red Legion"));

        for (Actionable a : actionables) {
            a.performAction();
        }
    }
}

