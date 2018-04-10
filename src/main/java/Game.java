import util.Console;
import util.Reader;
import util.Validation;

import java.io.IOException;
import java.util.List;

import static util.Validation.getNumber;

class Game {
    private static int raceCount;
    private Team team;

    Game() {
        team = new Team();
        raceCount = 0;
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
            Console.fillSpace(12, info.get(i * 2).length() + 3);
            System.out.println(info.get(i * 2 + 1));
        }
        return getNumber(1, info.size() / 2);
    }

    private int getRaceInt(List<String> info) {
        System.out.println("########################################");
        System.out.println("choose your race:");
        for (int i = 0; i < raceCount; i++) {
            System.out.print(i + 1 + ") " + info.get(i * 2));
            Console.fillSpace(12, info.get(i * 2).length() + 3);
            System.out.println(info.get(i * 2 + 1));
        }
        return getNumber(1, raceCount);
    }

    void displayTeamInfo() {
        team.printTeam();
    }

    void chooseLeader() {
        System.out.println("________________________________________");
        System.out.println("Choose your leader:");
        for (int i = 0; i < team.getHeroes().size(); i++) {
            System.out.print(i + 1 + ") ");
            team.getHeroes().get(i).printMainInfo();
        }
        team.setLeader(Validation.getNumber(1, team.getHeroes().size()));
    }


}
