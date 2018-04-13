import labyrinth.Dungeon;
import labyrinth.Room;
import util.Console;
import util.Reader;
import util.Validation;

import java.io.IOException;
import java.util.List;

import util.Colors;

import static util.Console.TAB;

class Game {
    private static int raceCount;
    private Team team;
    private Dungeon dungeon;

    Game() throws IOException {
        team = new Team();
        raceCount = 0;
        dungeon = new Dungeon();
    }

    void start() throws IOException {
        System.out.println("-----game name-----");
        System.out.println("there will be an introduction....\ncoming soon");
        for (int i = 0; i < 3; i++) {
            chooseHero();
        }
    }

    private void chooseHero() throws IOException {
        List<String> info = Reader.readFile("Race");
        raceCount = info.size() / 2;
        int id = getRaceInt(info);
        List<String> info2 = Reader.readFile("Race" + id);
        int spec = getSpecialityInt(info2);
        team.addHero(info.get((id - 1) * 2), info2.get((spec - 1) * 2), id, spec);
    }

    private int getSpecialityInt(List<String> info) {
        System.out.println("----------------------------------------");
        System.out.println("choose hero speciality: ");
        for (int i = 0; i < info.size() / 2; i++) {
            System.out.print(i + 1 + ") " + info.get(i * 2));
            Console.fillSpace(2 * TAB, info.get(i * 2).length() + 3, ".");
            System.out.println(info.get(i * 2 + 1));
        }
        return Validation.getNumber("answer: ", 1, info.size() / 2);
    }

    private int getRaceInt(List<String> info) {
        System.out.println("########################################");
        System.out.println("choose race:");
        for (int i = 0; i < raceCount; i++) {
            System.out.print(i + 1 + ") " + info.get(i * 2));
            Console.fillSpace(2 * TAB, info.get(i * 2).length() + 3, ".");
            System.out.println(info.get(i * 2 + 1));
        }
        return Validation.getNumber("answer: ", 1, raceCount);
    }

    void displayTeamInfo() {
        team.printTeam(Colors.CYAN, Colors.RESET);
    }

    void chooseLeader() {
        System.out.println("________________________________________");
        for (int i = 0; i < team.getHeroes().size(); i++) {
            System.out.print(i + 1 + ") ");
            team.getHeroes().get(i).printInfo();
        }
        team.setLeader(Validation.getNumber("Choose your leader:", 1, team.getHeroes().size()));
    }

    public Dungeon getLabyrinth() {
        return dungeon;
    }

    public void turn() {
        String s = dungeon.getRooms().get(team.getPosition()).getName();
        while (!s.equals("Exit")) {
            s = dungeon.getRooms().get(team.getPosition()).getName();
            chooseNextRoom();
        }
    }

    public void chooseNextRoom() {
        Room r = dungeon.getRooms().get(team.getPosition());
        roomSignboard("\u2440", "\u2441", r.getName());
        Console.printParagraph(r.getInfo());
        r.printExits(dungeon.getRooms());
        int next = Validation.getNumber("move to: ", 1, r.getExits().size());
        team.setPosition(r.getExits().get(next - 1));
    }

    private void roomSignboard(String s1, String s2, String name) {
        String line = new String(Colors.BLUE);
        line=randomLine(s1,s2,line,TAB*9+9 );
        System.out.println(line);
        line=new String(Colors.BLUE);
        line=randomLine(s1,s2,line,38 - name.length() / 2 );
        line += " "+Colors.RESET + name + Colors.BLUE+" ";
        line=randomLine(s1,s2,line,TAB*9+18);
        System.out.println(line);
        line=new String(Colors.BLUE);
        line=randomLine(s1,s2,line,TAB*9+9 );
        System.out.println(line+Colors.RESET);
    }

    private String randomLine(String s1, String s2,String line,int n) {
        while (line.length() < n) {
            if (Math.random() > 0.5) {
                line += s1;
            } else {
                line += s2;
            }
        }
        return line;
    }

    public void upgrade() {
        team.upgradeHeroes();
    }
}
