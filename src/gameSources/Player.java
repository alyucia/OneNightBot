package gameSources;

import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.core.entities.User;

public class Player implements Comparable<Player>{

    @Getter
    @Setter
    private String initRole;

    @Getter
    @Setter
    private Role currentRole;

    @Getter
    private User user;

    @Getter
    private String username;

    public Player(User user){
        this.user = user;
    }

    //must deprecate later
    public Player(String username) {
        this.username = username;
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

    public String getUsername() {
        return user.toString();
    }

    public int compareTo(Player comp){
        return (new Integer(this.getRole().getOrder())).compareTo(comp.getRole().getOrder());
    }

}
