package gameSources;

public class Minion extends Role{
    public Minion(){
        super("gameSources.Minion", false, 3);
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        for (int i = 0; i < players.length; i++) {
            if(players[i].getRole().getName().equals("gameSources.Werewolf")){
                System.out.println(players[i].getUser() + " is a gameSources.Werewolf");
            }
        }
    }
}
