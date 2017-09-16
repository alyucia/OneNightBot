package bot.goonbaya;

import java.util.*;

public class bot{
    public static void main(String[] args) {
        Game test = new Game(5);
        test.optIn();
        test.startGame();
    }
}

class Game{
    Scanner sc = new Scanner(System.in);
    private Player[] players;
    private Player[] playerOrder;
    private Role[] roles;
    private Role[] unused = new Role[3];
    public Game(int nplay){
        players = new Player[nplay];
        playerOrder = new Player[nplay];
        roles = new Role[nplay + 3];
        createRoles();
        shuffleRoles();
    }
    public void optIn(){
        String name;
        for (int i = 0; i < players.length; i++){
            System.out.println("Please enter your name");
            name = sc.nextLine();
            players[i] = new Player(name);
        }
    }
    public void startGame(){
        setRoles();
        setOrder();
        nightActions();
    }
    private void createRoles(){
        System.out.println("Which roles would you like?");
        System.out.println("1.Doppelganger\n2.Werewolf\n3.Werewolf\n4.Minion\n5.Mason\n6.Mason\n7.Seer\n8.Robber\n9.Troublemaker\n10.Drunk\n11.Insomniac\n12.Villager\n13.Villager\n14.Villager\n15.Hunter\n16.Tanner");
        String input = sc.nextLine();
        String[] inputArray = input.split(", ");
        for (int i = 0; i < inputArray.length; i++){
            switch(Integer.parseInt(inputArray[i])){
                case 1: roles[i] = new Doppelganger();
                        break;
                case 2: roles[i] = new Werewolf();
                        break;
                case 3: roles[i] = new Werewolf();
                        break;
                case 4: roles[i] = new Minion();
                        break;
                case 5: roles[i] = new Mason();
                        break;
                case 6: roles[i] = new Mason();
                        break;
                case 7: roles[i] = new Seer();
                        break;
                case 8: roles[i] = new Robber();
                        break;
                case 9: roles[i] = new Troublemaker();
                        break;
                case 10: roles[i] = new Drunk();
                        break;
                case 11: roles[i] = new Insomniac();
                        break;
                case 12: roles[i] = new Villager();
                        break;
                case 13: roles[i] = new Villager();
                        break;
                case 14: roles[i] = new Villager();
                        break;
                case 15: roles[i] = new Hunter();
                        break;
                case 16: roles[i] = new Tanner();
                        break;
            }
        }

    }
    private void setOrder(){
        for (int i = 0; i < players.length; i++)
            playerOrder[i] = players[i];
        Arrays.sort(playerOrder);
    }
    private void shuffleRoles(){
        int index;
        Role temp;
        Random random = new Random();
        for (int i = roles.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = roles[index];
            roles[index] = roles[i];
            roles[i] = temp;
        }
    }
    private void setRoles(){
        System.out.println("Setting roles!");
        for (int i = 0; i < players.length; i++) {
            players[i].setInitRole(roles[i]);
            System.out.println(roles[i].getName());
        }
        unused[0] = roles[players.length];
        unused[1] = roles[players.length + 1];
        unused[2] = roles[players.length + 2];
    }

    private void nightActions() {
        System.out.println("Starting night actions!");
        for (int i = 0; i < players.length; i++) {
            playerOrder[i].getRole().doAction(playerOrder[i], players, unused);
            //System.out.println(playerOrder[i].getUser());
            //System.out.println(playerOrder[i].getRole().getName());
        }
        if (playerOrder[0].getRole().doppelInsomniac)
            System.out.println("You are " + playerOrder[0].getRole().getName());
    }


}


class Player implements Comparable<Player>{
    private String initRole;
    private Role currentRole;
    private String username;

    public Player(String name){
        username = name;
    }

    public void setRole(Role newRole){
        currentRole = newRole;
    }
    public void setInitRole(Role init){
        currentRole = init;
        initRole = init.getName();
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
    public boolean doppelInsomniac;
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
        doppelInsomniac = false;
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        System.out.println("Pick a player to copy");
        int holder = sc.nextInt();
        System.out.println("You are now a" + players[holder].getRole().getName());
        if (players[holder].getRole().getName().equals("Insomniac")){
            doppelInsomniac = true;
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
            System.out.println("No other werewolves!\nChoose one card from the middle.");
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