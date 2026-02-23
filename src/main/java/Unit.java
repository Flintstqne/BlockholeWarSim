public class Unit {
    private String name;
    private int health;

    public Unit(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getRoleDescription() {
        return "Unit: General purpose unit.";
    }

    public void performSpecialAction() {
        System.out.println("Unit performs a generic action.");
    }
}
