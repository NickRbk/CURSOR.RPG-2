import labyrinth.Dungeon;
import labyrinth.Room;
import util.*;

import java.io.IOException;

import static util.Console.TAB;

class Game implements Colors, GameConstants {
    private Team team;
    private Dungeon dungeon;

    Game() {
        team = new Team();
        dungeon = new Dungeon();
    }

    void start() throws IOException {
        System.out.println("-----game name-----");
        System.out.println("there will be an introduction....\ncoming soon");
        team.createTeam();
        turn();
    }


    private void turn() {
        team.setPosition(dungeon.getRooms().get(0));
        String s = team.getPosition().getName();
        while (!"Exit".equals(s)) {
            s = team.getPosition().getName();
            chooseNextRoom();
        }
    }

    private void chooseNextRoom() {
        Room r = team.getPosition();
        roomSignboard(r.getName());
        Console.printParagraph(r.getDescription());
        r.printExits();
        int next = Validator.getNumber("move to: ", 1, r.getExits().size()) - 1;
        team.setPosition(r.getExits().get(next));
    }

    private void roomSignboard(String name) {
        String line = BLUE;
        line = randomLine(line, TAB * 9 + 9);
        System.out.println(line);
        line = BLUE;
        line = randomLine(line, 38 - name.length() / 2);
        line += " " + RESET + name + BLUE + " ";
        line = randomLine(line, TAB * 9 + 18);
        System.out.println(line);
        line = BLUE;
        line = randomLine(line, TAB * 9 + 9);
        System.out.println(line + RESET);
    }

    private String randomLine(String line, int n) {
        StringBuffer sb = new StringBuffer(100);
        sb.append(line);
        while (sb.length() < n) {
            sb.append((Math.random() > 0.5) ? S1 : S2);
        }
        return sb.toString();
    }
}
