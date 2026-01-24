public class Player {

    private String name;
    private String role;
    private int contributionPoints;
    private int level;
    private boolean active;

    public Player(String name, String role, int contributionPoints, int level, boolean active) {
        this.name = name;
        this.role = role;
        this.contributionPoints = contributionPoints;
        this.level = level;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getContributionPoints() {
        return contributionPoints;
    }

    public void setContributionPoints(int contributionPoints) {
        this.contributionPoints = contributionPoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', role='" + role + "', contributionPoints=" +
                contributionPoints + ", level=" + level + ", active=" + active + "}";
    }
}
