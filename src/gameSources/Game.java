package gameSources;

import gameSources.roles.*;
import net.dv8tion.jda.core.entities.MessageChannel;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game{
    Scanner sc = new Scanner(System.in);
    private Player[] players;
    private Player[] playerOrder;
    private Role[] roles;
    private Role[] unused = new Role[3];
    private MessageChannel mainChannel;

    public Game(int nplay, MessageChannel channel){
        this.mainChannel = channel;
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
        System.out.println("1.gameSources.roles.Doppelganger\n2.gameSources.roles.Werewolf\n3.gameSources.roles.Werewolf\n4.gameSources.roles.Minion\n5.gameSources.roles.Mason\n6.gameSources.roles.Mason\n7.gameSources.roles.Seer\n8.gameSources.roles.Robber\n9.gameSources.roles.Troublemaker\n10.gameSources.roles.Drunk\n11.gameSources.roles.Insomniac\n12.gameSources.roles.Villager\n13.gameSources.roles.Villager\n14.gameSources.roles.Villager\n15.gameSources.roles.Hunter\n16.gameSources.roles.Tanner");
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
