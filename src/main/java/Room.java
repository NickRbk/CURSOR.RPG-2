import lombok.Getter;

import java.util.ArrayList;

public class Room {
    private int minEnemyHp;
    @Getter
    private int id;
    @Getter
    private String name;
    @Getter
    private String info;
    //private boolean isExitsAreOpen;
    @Getter
    private ArrayList<Integer> exits;

    Room(String name, String info, int id) {
        this.id = id;
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
                    System.out.println(n + ")" + r.getName());
                    n++;
                }
            }
        }
    }

}
