package gameSources;

public class Werewolf extends Role{
    public Werewolf(){
        super("gameSources.Werewolf", true, 2);
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        boolean oneWolf = true;
        for (int i = 0; i < players.length; i++) {
            if(players[i].getRole().getWere() && players[i].getUser() != player.getUser()){
                System.out.println(players[i].getUser() + " is a gameSources.Werewolf");
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
