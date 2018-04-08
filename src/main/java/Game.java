import Util.Reader;
import Character.Hero;
import Util.Validation;

import java.io.IOException;
import java.util.List;

import static Util.Validation.checkNumber;

class Game {
    private static int raceCount;
    private Team team;

    Game() {
        team = new Team();
        raceCount = 0;
    }

    void start() throws IOException {
        System.out.println("-----game name-----");
        System.out.println("trere will be some intro....\ncomming soon");
        for (int i = 0; i < 3; i++) {
            chooseHero();
        }
    }

    private void chooseHero() throws IOException {
        List<String> info = Reader.readFile("Race");
        raceCount = info.size() / 2;
        int id = getRaceInt(info);
        List<String> info2 = Reader.readFile("Race" + id);
        int s = getSpecialityInt(info2);
        System.out.println("!!" + info.get((id - 1) * 2) + info2.get((s - 1) * 2));
        team.addHero(info.get((id - 1) * 2), info2.get((s - 1) * 2), id, s);
    }

    private int getSpecialityInt(List<String> info) {
        System.out.println("choose hero speciality: ");
        for (int i = 0; i < info.size() / 2; i++) {
            System.out.println(i + 1 + ") " + info.get(i * 2) + " --> " + info.get(i * 2 + 1));
        }
        return checkNumber(1, info.size() / 2);
    }

    private int getRaceInt(List<String> info) {
        System.out.println("choose your race:");
        for (int i = 0; i < raceCount; i++) {
            System.out.println(i + 1 + ") " + info.get(i * 2) + " --> " + info.get(i * 2 + 1));
        }
        return checkNumber(1, raceCount);
    }

    void displayTeamInfo() {
        team.printTeam();
    }

    void chooseLeader() {
        for (Hero h : team.getHeroes()) {
            h.printMainInfo();
        }
        team.setLeader(Validation.checkNumber(1, team.getHeroes().size()));
    }


}
