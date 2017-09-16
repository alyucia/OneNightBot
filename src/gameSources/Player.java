package gameSources;

public class Player implements Comparable<Player>{
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
