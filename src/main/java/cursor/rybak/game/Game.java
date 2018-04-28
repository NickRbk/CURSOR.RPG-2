package cursor.rybak.game;

import cursor.rybak.model.maze.Maze;
import cursor.rybak.model.team.Team;
import cursor.rybak.view.GeneralMessage;
import cursor.rybak.view.TeamMessage;

public class Game {
    public static void start() {
//        GeneralMessage.welcomeInfo();
//
//        String teamName = UserInteraction.askName("Team name");
//
//        Team team = new Team(teamName);
//        TeamMessage.printTeamInfo(team);

        Maze maze = new Maze();
        System.out.println(maze);

        System.out.println(maze.getStartRoom());
    }
}
