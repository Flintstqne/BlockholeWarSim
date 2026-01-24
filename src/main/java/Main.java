public class Main {

    public static void main(String[] args) {

        Player player = new Player("Alex", "Builder", 250, 3, true);
        Team team = new Team("Red Legion", 12, 5, "Red", true);
        Territory territory = new Territory("Iron Ridge", 2, 3, "Mountain", "Red Legion");
        WarPhase phase = new WarPhase(1, "Early War",
                "Limited equipment and preparation phase", false, false);
        GameWorld world = new GameWorld("Blockhole", 16, 2, 16, "Mixed Biomes");

        System.out.println(player.toString());
        System.out.println(team.toString());
        System.out.println(territory.toString());
        System.out.println(phase.toString());
        System.out.println(world.toString());
    }
}
