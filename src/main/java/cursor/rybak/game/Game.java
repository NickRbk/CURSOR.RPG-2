package cursor.rybak.game;

import cursor.rybak.view.displayingInfo;
import cursor.rybak.model.Team;
import cursor.rybak.util.*;

public class Game implements Colors, GameConstants ,displayingInfo {
    private Team team;

    public Game() {
        team = new Team();
    }

    public void start(){
        System.out.print("-------------------------------- ");
        System.out.print(GAME_NAME);
        System.out.println(" ------------------------------");
        Console.printParagraph(GAME_DESCRIPTION);
        team.createTeam();
    }
}
