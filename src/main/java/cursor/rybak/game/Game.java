package cursor.rybak.game;

import cursor.rybak.model.Team;
import cursor.rybak.util.*;

public class Game implements Colors, GameConstants {
    private Team team;

    public Game() {
        team = new Team();
    }

    public void start(){
        team.createTeam();
    }
}
