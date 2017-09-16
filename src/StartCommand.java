import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


    public class StartCommand extends ListenerAdapter
    {
        @Override
        public void onMessageReceived(MessageReceivedEvent event)
        {
            if (event.getAuthor().isBot()) return;
            // We don't want to respond to other bot accounts, including ourself
            Message message = event.getMessage();
            String content = message.getRawContent();
            // getRawContent() is an atomic getter
            // getContent() is a lazy getter which modifies the content for e.g. console view (strip discord formatting)
            if (content.equals("!whoIsGay"))
            {
                MessageChannel channel = event.getChannel();
                channel.sendMessage("bgo").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
            } else if(content.equals("!gg"))
            {
                MessageChannel channel = event.getChannel();
                channel.sendMessage("geeeee gee").queue();
            }
        }
    }

