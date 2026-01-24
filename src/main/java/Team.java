public class Team {

    private String name;
    private int playerCount;
    private int territoryCount;
    private String factionColor;
    private boolean atWar;

    public Team(String name, int playerCount, int territoryCount, String factionColor, boolean atWar) {
        this.name = name;
        this.playerCount = playerCount;
        this.territoryCount = territoryCount;
        this.factionColor = factionColor;
        this.atWar = atWar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public int getTerritoryCount() {
        return territoryCount;
    }

    public void setTerritoryCount(int territoryCount) {
        this.territoryCount = territoryCount;
    }

    public String getFactionColor() {
        return factionColor;
    }

    public void setFactionColor(String factionColor) {
        this.factionColor = factionColor;
    }

    public boolean isAtWar() {
        return atWar;
    }

    public void setAtWar(boolean atWar) {
        this.atWar = atWar;
    }

    @Override
    public String toString() {
        return "Team{name='" + name + "', playerCount=" + playerCount +
                ", territoryCount=" + territoryCount +
                ", factionColor='" + factionColor + "', atWar=" + atWar + "}";
    }
}
