package gameSources;

public class Doppelganger extends Role{
    public Doppelganger(){
        super("gameSources.Doppelganger", false, 1);
        doppelInsomniac = false;
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        System.out.println("Pick a player to copy");
        int holder = sc.nextInt();
        System.out.println("You are now a" + players[holder].getRole().getName());
        if (players[holder].getRole().getName().equals("gameSources.Insomniac")){
            doppelInsomniac = true;
            return;
        }
        else if (players[holder].getRole().getWere()){
            this.setWere(true);
        }
        players[holder].getRole().doAction(player, players, unused);
    }
}
