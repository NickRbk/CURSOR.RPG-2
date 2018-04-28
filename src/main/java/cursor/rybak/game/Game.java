package cursor.rybak.game;

import cursor.rybak.model.maze.Maze;
import cursor.rybak.model.maze.Room;
import cursor.rybak.model.team.Team;
import cursor.rybak.view.GeneralMessage;
import cursor.rybak.view.MazeMessage;
import cursor.rybak.view.TeamMessage;

public class Game {
    public static void start() {
        GeneralMessage.welcomeInfo();

        String teamName = UserInteraction.askName("Team name");

        Team team = new Team(teamName);
        TeamMessage.printTeamInfo(team);

        // Temporary make endless condition
        while(true) {
            Maze maze = new Maze();
            Room currentRoom = team.enterToMaze(maze);

            while(!currentRoom.isObjective()) {
                System.out.println(currentRoom);

                Battle.blitzkrieg(currentRoom); // simple battle phase

                MazeMessage.printNeighbors(currentRoom);
                String moveOption = UserInteraction.chooseMoveOption( currentRoom );

                currentRoom = team.move(currentRoom, moveOption);
            }

            System.out.println(currentRoom.getDescription());
        }
    }
}
