package gameSources;

public class Mason extends Role {
    public Mason() {
        super("gameSources.Mason", false, 4);
    }

    public void doAction(Player player, Player[] players, Role[] unused) {
        boolean oneMason = true;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getRole().getName().equals("gameSources.Mason") && players[i].getUser() != player.getUser()) {
                System.out.println(players[i].getUser() + " is a gameSources.Mason");
                oneMason = false;
            }
        }
        if (oneMason) {
            System.out.println("You are the only gameSources.Mason");
        }
    }
}
