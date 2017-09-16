package gameSources.roles;

import gameSources.Player;

public class Seer extends Role{
    public Seer(){
        super("gameSources.roles.Seer", false, 5);
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        System.out.println("Choose a player, or middle cards");
        int holder = sc.nextInt();
        if(holder == 1){
            System.out.println("Choose two cards from the middle.");
            holder = sc.nextInt();
            System.out.println("That card is " + unused[holder].getName());
            holder = sc.nextInt();
            System.out.println("That card is " + unused[holder].getName());
        }
        else {
            System.out.println(players[holder - 2] + " is a " + players[holder - 2]);
        }
    }

}
