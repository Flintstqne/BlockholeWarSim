public class WarPhase {

    private int phaseNumber;
    private String phaseName;
    private String description;
    private boolean weaponsUnlocked;
    private boolean vehiclesUnlocked;

    public WarPhase(int phaseNumber, String phaseName, String description,
                    boolean weaponsUnlocked, boolean vehiclesUnlocked) {
        this.phaseNumber = phaseNumber;
        this.phaseName = phaseName;
        this.description = description;
        this.weaponsUnlocked = weaponsUnlocked;
        this.vehiclesUnlocked = vehiclesUnlocked;
    }

    public int getPhaseNumber() {
        return phaseNumber;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public String getDescription() {
        return description;
    }

    public boolean isWeaponsUnlocked() {
        return weaponsUnlocked;
    }

    public boolean isVehiclesUnlocked() {
        return vehiclesUnlocked;
    }

    public void setPhaseNumber(int phaseNumber) {
        this.phaseNumber = phaseNumber;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeaponsUnlocked(boolean weaponsUnlocked) {
        this.weaponsUnlocked = weaponsUnlocked;
    }

    public void setVehiclesUnlocked(boolean vehiclesUnlocked) {
        this.vehiclesUnlocked = vehiclesUnlocked;
    }

    @Override
    public String toString() {
        return "WarPhase{phaseNumber=" + phaseNumber + ", phaseName='" +
                phaseName + "', description='" + description +
                "', weaponsUnlocked=" + weaponsUnlocked +
                ", vehiclesUnlocked=" + vehiclesUnlocked + "}";
    }
}
