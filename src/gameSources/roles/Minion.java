package gameSources.roles;

import gameSources.Player;

public class Minion extends Role{
    public Minion(){
        super("gameSources.roles.Minion", false, 3);
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        for (int i = 0; i < players.length; i++) {
            if(players[i].getRole().getName().equals("gameSources.roles.Werewolf")){
                System.out.println(players[i].getUser() + " is a gameSources.roles.Werewolf");
            }
        }
    }
}
