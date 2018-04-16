import labyrinth.Dungeon;

import util.*;

class Game implements Colors, GameConstants {
    private Team team;
    private Dungeon dungeon;

    Game() {
        team = new Team();
        dungeon = new Dungeon();
    }

    void start(){
        System.out.println("-----game name-----");
        System.out.println("there will be an introduction....\ncoming soon");
        //team.createTeam();
        turn();
    }

    private void turn() {
        team.setPosition(dungeon.getRooms().get(0));
        String s = team.getPosition().getName();
        while (!"Exit".equals(s)) {
            s = team.getPosition().getName();
            team.setPosition(dungeon.chooseNextRoom(team.getPosition()));
        }
    }


}
