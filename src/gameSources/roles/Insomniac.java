package gameSources.roles;

import gameSources.Player;

public class Insomniac extends Role{
    public Insomniac(){
        super("gameSources.roles.Insomniac", false, 9);
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        System.out.println("You are " + player.getRole().getName());
    }
}
