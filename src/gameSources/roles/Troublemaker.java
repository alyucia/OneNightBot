package gameSources.roles;

import gameSources.Player;

public class Troublemaker extends Role{
    public Troublemaker(){
        super("gameSources.roles.Troublemaker", false, 7);
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        System.out.println("Pick two players to switch");
        int a = sc.nextInt();
        int b = sc.nextInt();
        Role temp = players[a].getRole();
        players[a].setRole(players[b].getRole());
        players[b].setRole(temp);
        System.out.println("You switched" + players[a].getUser() + " and " + players[b].getUser());
    }
}