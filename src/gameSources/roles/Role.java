package gameSources.roles;


import gameSources.Player;

import java.util.Scanner;

public abstract class Role{
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
