package bot;

import gameSources.GameRunner;
import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GameListener extends ListenerAdapter{

    @Getter
    private static GameRunner gameRunner = new GameRunner();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(!event.getAuthor().isBot() && event.getChannel().getId().equals("358545804165906433")) {
            System.out.println(event.getMessage().getStrippedContent());
            gameRunner.handleCommand(event);
        }
    }
}
