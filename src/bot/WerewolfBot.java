package bot;

import gameSources.GameRunner;
import lombok.Getter;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class WerewolfBot {

    private static final String BOT_TOKEN =
        "MzU4MzY4ODg0NDI1ODgzNjUw.DJ3fug.n9RQu6T6-pA5EYSUKQa017OmQHU";

    @Getter
    private static JDA jda;

    public static void main(String[] args)
        throws LoginException, RateLimitedException, InterruptedException
    {
        jda = new JDABuilder(AccountType.BOT).setToken(BOT_TOKEN).buildAsync();
        jda.addEventListener(new GameListener());
    }
}
