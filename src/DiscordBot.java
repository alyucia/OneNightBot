import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;

public class DiscordBot {

    private static final String BOT_TOKEN =
        "MzU4MzY4ODg0NDI1ODgzNjUw.DJ3fug.n9RQu6T6-pA5EYSUKQa017OmQHU";

    public static void main(String[] args)
    {
        try {
            JDABuilder jdaBuilder = new JDABuilder(AccountType.BOT).setToken(BOT_TOKEN);
            jdaBuilder.buildAsync();
            jdaBuilder.addEventListener(new StartCommand());
        } catch (java.lang.Exception exception) {
            exception.printStackTrace();
        }

    }
}
