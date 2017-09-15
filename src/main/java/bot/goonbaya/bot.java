package bot.goonbaya;

import java.util.*;

public class bot{
    public static void main(String[] args) {

    }
}

class game{
    Player[] players;
    Player[] playerOrder;
    Role[] roles;
    Role[] unused;
    public game(int nplay){
        players = new Player[nplay];
    }

    public void setOrder(){
        Arrays.sort(playerOrder);
    }
}


class Player implements Comparable<Player>{
    private String initRole;
    private Role currentRole;
    private String username;

    public Player(Role init){
        currentRole = init;
        initRole = init.getName();
    }

    public void setRole(Role newRole){
        currentRole = newRole;
    }

    public Role getRole(){
        return currentRole;
    }

    public String firstRole(){
        return initRole;
    }

    public String getUser(){
        return username;
    }

    public int compareTo(Player comp){
        return (new Integer(this.getRole().getOrder())).compareTo(comp.getRole().getOrder());
    }


}

class Role{
    Scanner sc = new Scanner(System.in);
    private boolean were;
    private int order;
    private String name;
    public Role(String n, boolean w, int o){
        name = n;
        were = w;
        order = o;

    }
    public void doAction(Player player, Player[] players, Role[] unused){}
    public boolean getWere(){
        return were;
    }
    public void setWere(boolean w){
        this.were = w;
    }
    public int getOrder(){
        return order;
    }
    public String getName(){
        return name;
    }

}

class Doppelganger extends Role{
    public Doppelganger(){
        super("Doppelganger", false, 1);
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        System.out.println("Pick a player to copy");
        int holder = sc.nextInt();
        System.out.println("You are now a" + players[holder].getRole().getName());
        if (players[holder].getRole().getName().equals("Insomniac")){
            //figure out insomniac shit here
            return;
        }
        else if (players[holder].getRole().getWere()){
            this.setWere(true);
        }
        players[holder].getRole().doAction(player, players, unused);
    }
}

class Werewolf extends Role{
    public Werewolf(){
        super("Werewolf", true, 2);
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        boolean oneWolf = true;
        for (int i = 0; i < players.length; i++) {
            if(players[i].getRole().getWere() && players[i].getUser() != player.getUser()){
                System.out.println(players[i].getUser() + " is a Werewolf");
                oneWolf = false;
            }
        }
        if (oneWolf){
            System.out.println("Choose one card from the middle.");
            int holder = sc.nextInt();
            System.out.println("That card is " + unused[holder].getName());
        }
    }
}

class Minion extends Role{
    public Minion(){
        super("Minion", false, 3);
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        for (int i = 0; i < players.length; i++) {
            if(players[i].getRole().getName().equals("Werewolf")){
                System.out.println(players[i].getUser() + " is a Werewolf");
            }
        }
    }
}

class Mason extends Role{
    public Mason(){
        super("Mason", false, 4);
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        boolean oneMason = true;
        for (int i = 0; i < players.length; i++) {
            if(players[i].getRole().getName().equals("Mason") && players[i].getUser() != player.getUser()){
                System.out.println(players[i].getUser() + " is a Mason");
                oneMason = false;
            }
        }
        if (oneMason){
            System.out.println("You are the only Mason");
        }
    }
}

class Seer extends Role{
    public Seer(){
        super("Seer", false, 5);
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

class Robber extends Role{
    public Robber(){
        super("Robber", false, 6);
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

class Troublemaker extends Role{
    public Troublemaker(){
        super("Troublemaker", false, 7);
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

class Drunk extends Role{
    public Drunk(){
        super("Drunk", false, 8);
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        System.out.println("Pick an unused role to switch with.");
        int holder = sc.nextInt();
        Role temp = player.getRole();
        player.setRole(unused[holder - 1]);
        unused[holder - 1] = temp;
    }
}

class Insomniac extends Role{
    public Insomniac(){
        super("Insomniac", false, 9);
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        System.out.println("You are " + player.getRole().getName());
    }
}

class Tanner extends Role{
    public Tanner(){
        super("Tanner", false, 0);
    }

}

class Hunter extends Role{
    public Hunter(){
        super("Hunter", false, 0);
    }
}

class Villager extends Role{
    public Villager(){
        super("Villager", false, 0);
    }
}