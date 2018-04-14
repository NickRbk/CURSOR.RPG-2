package labyrinth;

import lombok.Getter;
import util.Colors;

import java.util.ArrayList;

public class Room implements Colors {
    @Getter
    private String name;
    @Getter
    public String description;
    @Getter
    public String doorSignboard;
    //private boolean isExitsAreOpen;
    @Getter
    private ArrayList<Room> exits = new ArrayList<>();

    Room(RoomDescription rd) {
        this.name = rd.name;
        this.doorSignboard = rd.doorSignboard;
        this.description = rd.description;
    }


    void addExit(Room r) {
        exits.add(r);
    }

    public void printExits() {
        int n = 1;
        for (Room r : exits) {
            System.out.println(GREEN + "\u2B9A" + RESET + "[" + n + "] "+((n==1 && !"Start".equals(name))?"(back) ":"") + r.getDoorSignboard());
            n++;
        }
    }

}
