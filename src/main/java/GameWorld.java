public class GameWorld {

    private String worldName;
    private int mapSize;
    private int totalTeams;
    private int totalTerritories;
    private String climateTheme;

    public GameWorld(String worldName, int mapSize, int totalTeams,
                     int totalTerritories, String climateTheme) {
        this.worldName = worldName;
        this.mapSize = mapSize;
        this.totalTeams = totalTeams;
        this.totalTerritories = totalTerritories;
        this.climateTheme = climateTheme;
    }

    public String getWorldName() {
        return worldName;
    }

    public int getMapSize() {
        return mapSize;
    }

    public int getTotalTeams() {
        return totalTeams;
    }

    public int getTotalTerritories() {
        return totalTerritories;
    }

    public String getClimateTheme() {
        return climateTheme;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public void setTotalTeams(int totalTeams) {
        this.totalTeams = totalTeams;
    }

    public void setTotalTerritories(int totalTerritories) {
        this.totalTerritories = totalTerritories;
    }

    public void setClimateTheme(String climateTheme) {
        this.climateTheme = climateTheme;
    }

    @Override
    public String toString() {
        return "GameWorld{worldName='" + worldName + "', mapSize=" + mapSize +
                ", totalTeams=" + totalTeams +
                ", totalTerritories=" + totalTerritories +
                ", climateTheme='" + climateTheme + "'}";
    }
}
