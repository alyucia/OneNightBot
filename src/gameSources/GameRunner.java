package gameSources;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.*;

public class GameRunner{

    public static final String HELP_STRING = "run game with \"!setup, [numPlayers]\"";
    public static final int MAX_PLAYERS = 13;

    public void handleCommand(MessageReceivedEvent event) {

        String msg = event.getMessage().getStrippedContent();
        if(msg.equals("!help")) {
            event.getChannel().sendMessage(HELP_STRING).queue();
        }
        if(msg.startsWith("!setup")) {
            String[] parts = msg.split(",");
            if(parts.length < 2) {
                return;
            }
            String num = parts[1].replaceAll("\\s", "");
            try {
                int numPlayers = Integer.parseInt(num);
                if(numPlayers > MAX_PLAYERS) {
                    throw new NumberFormatException();
                }
                this.run(numPlayers, event.getChannel());
            } catch(NumberFormatException exception) {
                event.getChannel().sendMessage("Invalid number of players(must be integer 13 or less). found: \"" +
                    num + "\"").queue();
                return;
            }
        }
    }
    public void run(int numPlayers, MessageChannel channel) {
        Game test = new Game(numPlayers, channel);
        test.optIn();
        test.startGame();
    }
}






