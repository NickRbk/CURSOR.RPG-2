package cursor.rybak.game;

import cursor.rybak.model.Team;

public class Game {
    private Team team;

    public Game() {
        team = new Team();
    }

    public void start(){
        team.createTeam();
    }
}
