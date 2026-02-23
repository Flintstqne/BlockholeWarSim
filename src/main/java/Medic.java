public class Medic extends Unit {
    private int medkits;

    public Medic(String name, int health, int medkits) {
        super(name, health);
        this.medkits = medkits;
    }

    public int getMedkits() {
        return medkits;
    }

    public void setMedkits(int medkits) {
        this.medkits = medkits;
    }

    @Override
    public String getRoleDescription() {
        return "Medic: Support unit for healing.";
    }

    @Override
    public void performSpecialAction() {
        System.out.println("In performSpecialAction(): My class type is Medic. Medic heals with " + medkits + " medkits.");
    }
}
