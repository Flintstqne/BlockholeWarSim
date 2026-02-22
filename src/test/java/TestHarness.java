// Manual test harness for Player and Team classes
public class TestHarness {
    public TestHarness() {
        // Test Player class
        System.out.println("Testing Player class...");
        Player player = new Player("Alex", "Builder", 250, 3, true);
        System.out.println(player.toString());
        // Test getters
        System.out.println("Name: " + player.getName());
        System.out.println("Role: " + player.getRole());
        System.out.println("Contribution Points: " + player.getContributionPoints());
        System.out.println("Level: " + player.getLevel());
        System.out.println("Active: " + player.isActive());
        // Test setters
        player.setName("Steve");
        player.setRole("Warrior");
        player.setContributionPoints(500);
        player.setLevel(5);
        player.setActive(false);
        System.out.println(player.toString());
        // Test getters after setters
        System.out.println("Name: " + player.getName());
        System.out.println("Role: " + player.getRole());
        System.out.println("Contribution Points: " + player.getContributionPoints());
        System.out.println("Level: " + player.getLevel());
        System.out.println("Active: " + player.isActive());

        // Test Team class
        System.out.println("\nTesting Team class...");
        Team team = new Team("Red Legion", 12, 5, "Red", true);
        System.out.println(team.toString());
        // Test getters
        System.out.println("Name: " + team.getName());
        System.out.println("Player Count: " + team.getPlayerCount());
        System.out.println("Territory Count: " + team.getTerritoryCount());
        System.out.println("Faction Color: " + team.getFactionColor());
        System.out.println("At War: " + team.isAtWar());
        // Test setters
        team.setName("Blue Brigade");
        team.setPlayerCount(10);
        team.setTerritoryCount(3);
        team.setFactionColor("Blue");
        team.setAtWar(false);
        System.out.println(team.toString());
        // Test getters after setters
        System.out.println("Name: " + team.getName());
        System.out.println("Player Count: " + team.getPlayerCount());
        System.out.println("Territory Count: " + team.getTerritoryCount());
        System.out.println("Faction Color: " + team.getFactionColor());
        System.out.println("At War: " + team.isAtWar());
    }

    public static void main(String[] args) {
        new TestHarness();
    }
}

