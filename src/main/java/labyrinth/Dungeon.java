package labyrinth;

import util.Console;
import util.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dungeon{
    private ArrayList<Room> rooms;
    private int maxLength;

    public Dungeon() throws IOException {
        rooms = new ArrayList<>();
        maxLength = 7 + (int) (Math.random() * 2 + 0.1);
        labyrinthGenerator();
    }

    private void labyrinthGenerator() throws IOException {
        List<String> list = Reader.readFile("roomsTMP");   //get list with all possible rooms
        Room r1 = new Room(list.get(0), list.get(1), list.get(2), 0);
        Room r2 = new Room(list.get(0), list.get(1), list.get(2), 0);
        createMainLine(list, r1, r2);
        for (int i = 0; i < Math.random() * 2 + 2; i++) {
            createSideline(list, r1, r2);
        }
    }

    private void createMainLine(List<String> list, Room r1, Room r2) {
        rooms.add(r1); //set start
        for (int i = 1; i < maxLength; i++) {
            int number1 = (int) (Math.random() * 11 + 0.01) * 3 + 6;
            r2 = new Room(list.get(number1), list.get(number1 + 1), list.get(number1 + 2), i);
            setExits(r1, r2);
            rooms.add(r2);
            r1 = r2;
        }
        r2 = new Room(list.get(3), list.get(4), list.get(5), rooms.size());
        setExits(r1, r2);
        rooms.add(r2);//set exit
    }

    private void createSideline(List<String> list, Room r1, Room r2) {
        int j = (int) (Math.random() * (rooms.size() - 2) + 0.01);
        r1 = rooms.get(j);
        for (int i = 0; i < Math.random() * 3; i++) {
            int number1 = (int) (Math.random() * 12 + 0.01) * 2 + 4;
            r2 = new Room(list.get(number1), list.get(number1 + 1),list.get(number1 + 2), rooms.size());
            setExits(r1, r2);
            rooms.add(r2);
            r1 = r2;
        }

    }

    private void setExits(Room r1, Room r2) {
        r1.addExit(r2.getId());
        r2.addExit(r1.getId());
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
