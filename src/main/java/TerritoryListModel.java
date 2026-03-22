import java.util.ArrayList;

public class TerritoryListModel {

    private final ArrayList<Territory> territories;

    public TerritoryListModel() {
        territories = new ArrayList<>();

        // Seed data so first launch immediately shows a valid first record.
        territories.add(new Territory("Iron Ridge", 2, 3, "Mountain", "Red Legion"));
        territories.add(new Territory("River Watch", 8, 1, "Plains", "Blue Guard"));
        territories.add(new Territory("Ash Hollow", 5, 9, "Volcanic", "Green Alliance"));
    }

    public int size() {
        return territories.size();
    }

    public boolean isEmpty() {
        return territories.isEmpty();
    }

    public Territory getAt(int index) {
        return territories.get(index);
    }

    public void add(Territory territory) {
        territories.add(territory);
    }

    public void updateAt(int index, Territory territory) {
        territories.set(index, territory);
    }

    public Territory deleteAt(int index) {
        return territories.remove(index);
    }

    public ArrayList<Territory> getTerritories() {
        return territories;
    }
}

