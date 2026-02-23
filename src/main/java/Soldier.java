public class Soldier extends Unit {
    private String weaponType;

    public Soldier(String name, int health, String weaponType) {
        super(name, health);
        this.weaponType = weaponType;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public String getRoleDescription() {
        return "Soldier: Frontline combat unit.";
    }

    @Override
    public void performSpecialAction() {
        System.out.println("In performSpecialAction(): My class type is Soldier. Soldier attacks with " + weaponType + ".");
    }
}
