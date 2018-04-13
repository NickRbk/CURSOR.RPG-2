package labyrinth;

import lombok.Getter;
import util.Colors;

import java.util.ArrayList;

public class Room {
    private int minEnemyHp;
    @Getter
    private int id;
    @Getter
    private String name;
    @Getter
    private String info;
    @Getter
    private String message;
    //private boolean isExitsAreOpen;
    @Getter
    private ArrayList<Integer> exits;

    Room(String name, String message, String info, int id) {
        this.id = id;
        this.message = message;
        this.info = info;
        exits = new ArrayList<>();
        this.name = name;
        //isExitsAreOpen=true;
    }

    public void addExit(Integer i) {
        exits.add(i);
    }

    public void printExits(ArrayList<Room> rooms) {
        int n = 1;
        for (Integer i : exits) {
            for (Room r : rooms) {
                if (r.getId() == i) {
                    System.out.println(Colors.GREEN+"\u2B9A"+Colors.RESET+"["+n + "] " + r.getMessage());
                    n++;
                }
            }
        }
    }

}
