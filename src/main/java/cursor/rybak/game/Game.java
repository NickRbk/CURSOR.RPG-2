package cursor.rybak.game;

import cursor.rybak.model.maze.Maze;
import cursor.rybak.model.room.Room;
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

        launch(team);
    }

    private static void launch(Team team) {
        Maze maze = new Maze();
        Room currentRoom = team.enterToMaze(maze);

        while (!currentRoom.isObjective() && isHeroAlive(team)) {
            boolean isBattle = true;
            System.out.println(currentRoom);

            if (currentRoom.isMonsterPresent()) {
                isBattle = Battle.blitzkrieg(currentRoom); // simple battle phase
            }

            currentRoom = move(currentRoom, team, isBattle);
        }

        printGameOverMessage(currentRoom, team);
    }


    /**
     * move Team to another location
     *
     * @param currentRoom current location
     * @param team        our Team
     * @param isBattle    flag about was there a battle
     * @return new Room
     */
    private static Room move(Room currentRoom, Team team, boolean isBattle) {
        if (isBattle) {
            MazeMessage.printNeighbors(currentRoom);
            String moveOption = UserInteraction.chooseMoveOption(currentRoom);

            return team.move(currentRoom, moveOption);
        } else {
            Room previousRoom = currentRoom.getPrevious();
            String roomIndex = Integer.toString(currentRoom.getChainedTo().indexOf(previousRoom) + 1);

            return team.move(currentRoom, roomIndex);
        }
    }

    private static boolean isHeroAlive(Team team) {
        return team.getHeroes().get(0).getHealth() > 0;
    }

    private static void printGameOverMessage(Room currentRoom, Team team) {
        if (isHeroAlive(team)) System.out.println(currentRoom.getDescription());
        else GeneralMessage.gameOverInfo();
    }
}