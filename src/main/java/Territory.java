public class Territory {

    private String name;
    private int xCoordinate;
    private int yCoordinate;
    private String terrainType;
    private String ownerTeam;

    public Territory(String name, int xCoordinate, int yCoordinate, String terrainType, String ownerTeam) {
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.terrainType = terrainType;
        this.ownerTeam = ownerTeam;
    }

    public String getName() {
        return name;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public String getTerrainType() {
        return terrainType;
    }

    public String getOwnerTeam() {
        return ownerTeam;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void setTerrainType(String terrainType) {
        this.terrainType = terrainType;
    }

    public void setOwnerTeam(String ownerTeam) {
        this.ownerTeam = ownerTeam;
    }

    @Override
    public String toString() {
        return "Territory{name='" + name + "', x=" + xCoordinate +
                ", y=" + yCoordinate + ", terrainType='" + terrainType +
                "', ownerTeam='" + ownerTeam + "'}";
    }
}
