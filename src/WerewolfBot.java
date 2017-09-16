import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class WerewolfBot extends ListenerAdapter {

    private static final String BOT_TOKEN =
        "MzU4MzY4ODg0NDI1ODgzNjUw.DJ3fug.n9RQu6T6-pA5EYSUKQa017OmQHU";

    public static void main(String[] args)
        throws LoginException, RateLimitedException, InterruptedException
    {
        JDA jda = new JDABuilder(AccountType.BOT).setToken(BOT_TOKEN).buildBlocking();
        jda.addEventListener(new WerewolfBot());
    }



    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(!event.getAuthor().isBot()) {
            if (event.getMessage().getContent().equals("!gg")) {
                System.out.println("gg");
                event.getTextChannel().sendMessage("geeeeeee geee").queue();
            }
        }
    }
}
