package gameSources.roles;

import gameSources.Player;

public class Robber extends Role{
    public Robber(){
        super("gameSources.roles.Robber", false, 6);
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        System.out.println("Pick a user to switch with.");
        int holder = sc.nextInt();
        System.out.println(players[holder].getUser() + " is a " + players[holder].getRole().getName());
        Role temp = player.getRole();
        player.setRole(players[holder].getRole());
        players[holder].setRole(temp);
    }
}
