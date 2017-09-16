package gameSources;

public class Drunk extends Role{
    public Drunk(){
        super("gameSources.Drunk", false, 8);
    }
    public void doAction(Player player, Player[] players, Role[] unused){
        System.out.println("Pick an unused role to switch with.");
        int holder = sc.nextInt();
        Role temp = player.getRole();
        player.setRole(unused[holder - 1]);
        unused[holder - 1] = temp;
    }
}
