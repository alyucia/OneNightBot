package gameSources;

import net.dv8tion.jda.core.JDA;

import java.util.*;

public class GameRunner{

    private JDA jda;

    public GameRunner(JDA jda) {
        this.jda = jda;
        Game test = new Game(5);
        test.optIn();
        test.startGame();
    }
}






