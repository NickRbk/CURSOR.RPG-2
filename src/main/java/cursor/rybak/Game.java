package cursor.rybak;

import cursor.rybak.util.*;

class Game implements Colors, GameConstants ,displayingInfo{
    private Team team;

    Game() {
        team = new Team();
    }

    void start(){
        System.out.print("-------------------------------- ");
        System.out.print(GAME_NAME);
        System.out.println(" ------------------------------");
        Console.printParagraph(GAME_DESCRIPTION);
        team.createTeam();
    }
}
