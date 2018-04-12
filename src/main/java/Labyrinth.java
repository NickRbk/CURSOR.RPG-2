/*import util.Console;
import util.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Labyrinth {
    private ArrayList<Room> labyrinth;
    private int maxLength;

    Labyrinth() throws IOException {
        labyrinth = new ArrayList<>();
        maxLength = 7 + (int) (Math.random() * 2 + 0.1);
        labyrinthGenerator();
    }

    private void labyrinthGenerator() throws IOException {
        List<String> list = Reader.readFile("rooms");   //get list with all possible rooms
        Room r1 = new Room(list.get(0),0);
        Room r2 = new Room(list.get(0),0);
        createMainLine(list,r1,r2);
        for(int i=0;i<Math.random()*2+2;i++){
            createSideline(list,r1,r2);
        }
    }

    private void createMainLine(List<String> list,Room r1,Room r2){
        labyrinth.add(r1); //set start
        for (int i = 1; i < maxLength; i++) {
            int number1 = (int) (Math.random() * 12 + 0.01) * 2 + 4;
            r2 = new Room(list.get(number1),i);
            setExits(r1,r2);
            labyrinth.add(r2);
            r1 = r2;
        }
        r2 = new Room(list.get(2),labyrinth.size());
        setExits(r1,r2);
        labyrinth.add(r2);//set exit
    }

    private void createSideline(List<String> list,Room r1,Room r2){
        int j=(int)(Math.random()*(labyrinth.size()-2)+0.01);
        r1=labyrinth.get(j);
        for(int i=0;i<Math.random()*3;i++){
            int number1 = (int) (Math.random() * 12 + 0.01) * 2 + 4;
            r2 = new Room(list.get(number1),labyrinth.size());
            setExits(r1,r2);
            labyrinth.add(r2);
            r1=r2;
        }

    }

    private void setExits(Room r1,Room r2){
        r1.addExit(r2.getId());
        r2.addExit(r1.getId());
    }

    void printRooms() {
        for (Room r : labyrinth) {
            System.out.print(r.getId()+ " " + r.getName());
            Console.fillSpace(2 * Console.TAB, r.getName().length());
            r.printExits();
        }
    }

    public ArrayList<Room> getRooms() {
        return labyrinth;
    }
}
*/