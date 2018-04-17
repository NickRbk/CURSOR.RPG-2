package labyrinth;

import util.Colors;
import util.Console;
import util.GameConstants;
import util.Validator;
import java.util.ArrayList;

public class Dungeon implements Colors, GameConstants {
    private ArrayList<Room> rooms;
    private int maxLength;

    public Dungeon() {
        rooms = new ArrayList<>();
        maxLength = LABYRINTH_MAIN_LINE_LENGTH + (int) (Math.random() * 3);
        dungeonGenerator();
    }

    private void dungeonGenerator() {
        createMainLine();
        for (int i = 0; i < LABYRINTH_SIDE_LINE_LENGTH; i++) {
            createSideline();
        }
    }

    private void createMainLine() {
        Room r1 = new Room(RoomDescription.START);
        Room r2;
        rooms.add(r1); //set start
        for (int i = 1; i < maxLength; i++) {
            int number1 = (int) (Math.random() * (RoomDescription.values().length-2));
            r2 = new Room(RoomDescription.valueOf("R" + number1));
            setExits(r1, r2);
            rooms.add(r2);
            r1 = r2;
        }
        r2 = new Room(RoomDescription.EXIT);
        setExits(r1, r2);
        rooms.add(r2);//add exit
    }

    private void createSideline() {
        int j = (int) (Math.random() * (maxLength - 1)) + 1;
        Room r1 = rooms.get(j);
        for (int i = 0; i < Math.random() * 2+3; i++) {
            int number1 = (int) (Math.random() * (RoomDescription.values().length-2));
            Room r2 = new Room(RoomDescription.valueOf("R" + number1));
            setExits(r1, r2);
            rooms.add(r2);
            r1 = r2;
        }
    }

    private void setExits(Room r1, Room r2) {
        r1.addExit(r2);
        r2.addExit(r1);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Room chooseNextRoom(Room r) {
        roomSignboard(r.getName());
        Console.printParagraph(r.getDescription());
        r.printExits();
        int next = Validator.getNumber("move to: ", 1, r.getExits().size()) - 1;
        return r.getExits().get(next);
    }

    private void roomSignboard(String name) {
        System.out.print(BLUE);
        String line=randomLine(PARAGRAPH_LENGTH);
        System.out.println(line);
        line = randomLine(PARAGRAPH_LENGTH/2 - name.length() / 2);
        System.out.print(line);
        line+=" "+name+" ";
        System.out.print(" " + RESET + name + BLUE + " ");
        line = randomLine(PARAGRAPH_LENGTH - line.length());
        System.out.println(line);
        line=randomLine(PARAGRAPH_LENGTH);
        System.out.println(line + RESET);
    }

    private String randomLine(int n) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < n) {
            sb.append((Math.random() > CHANCE_50) ? S1 : S2);
        }
        return sb.toString();
    }
}
