
import java.util.ArrayList;
import java.util.List;

import character.Hero;
import character.RacesVariants;
import character.Specialities;
import labyrinth.Room;
import lombok.Getter;
import lombok.Setter;
import util.Colors;
import util.GameConstants;
import util.Validator;

import static util.Console.fillSpace;

class Team implements Colors, GameConstants {
    @Setter
    @Getter
    private Room position;
    @Getter
    private List<Hero> heroes = new ArrayList<>();

    Team() {
    }

    void createTeam() {
        for (int i = 0; i < 3; i++) {
            chooseHero();
        }
        chooseLeader();
        printTeam();
        upgradeHeroes();
    }

    ///////////////////////////////////////////////createTeam///////////////////////////////////////////////////////////////
    private void chooseHero() {
        RacesVariants rv = getRace();
        Specialities spec = getSpeciality(rv);
        heroes.add(new Hero(rv, spec));
    }

    private Specialities getSpeciality(RacesVariants rv) {
        int answer;
        do {
            displaySpecialities(rv.name());
            answer = Validator.getNumber("answer: ", 0, Specialities.values().length / 3);
            if (answer == 0) {
                System.out.println("here will be specialities info");
            }
        } while (answer == 0);
        return Specialities.valueOf(rv.name() + "S" + answer);
    }

    private RacesVariants getRace() {
        int answer;
        do {
            displayRaces();
            answer = Validator.getNumber("answer: ", 0, RacesVariants.values().length);
            if (answer == 0) {
                System.out.println("here will be races info");
            }
        } while (answer == 0);
        return RacesVariants.valueOf("R" + answer);
    }

    private void displayRaces() {
        System.out.println("############################################################################");
        System.out.println("choose race:");
        System.out.print("[0 info] ");
        for (int i = 1; i <= RacesVariants.values().length; i++) {
            System.out.print("[" + i + " " + RacesVariants.valueOf("R" + i).name + "] ");
        }
        System.out.print(": ");
    }

    private void displaySpecialities(String raceName) {
        System.out.println("choose speciality: ");
        System.out.print("[0 info] ");
        for (int i = 0; i < Specialities.values().length / 3; i++) {
            System.out.print("[" + (i + 1) + " " + Specialities.valueOf(raceName + "S" + (i + 1)).name + "] ");
        }
        System.out.print(": ");
    }

    private void chooseLeader() {
        System.out.println(" Choose who will be the leader: ");
        for (int i = 0; i < heroes.size(); i++) {
            System.out.print("[" + (i + 1) + " ");
            heroes.get(i).printInfo();
            System.out.print("] ");
        }
        setLeader(Validator.getNumber("", 1, heroes.size()));
    }

    //////////////////////////////////////endCreateTeam/////////////////////////////////////////////////////////////////////
    //////////////////  print heroes table /////////////////////////////////////////////////////////////////////////////
    private void printTeam() {
        printLine(TABLE_COLOR + "\u250F", "\u2533", "\u2513" + RESET);
        printHeroesNames();
        printHeroesRace();
        printLine(TABLE_COLOR + "\u2523", "\u254B", "\u252B" + RESET);
        printHeroesParameters();
        printLeader();
        printLine(TABLE_COLOR + "\u2517", "\u253B", "\u251B" + RESET);
    }

    private void printHeroesParameters() {
        for (int j = 0; j < GameConstants.parametersNames.length; j++) {
            for (Hero h : heroes) {
                System.out.print(TABLE_COLOR + "\u2503" + RESET);
                String name = GameConstants.parametersNames[j];
                String number = Double.toString(h.getParametersNumbers().get(j));
                System.out.print(name);
                fillSpace(2 * TAB, name.length(), ".");
                System.out.print(number);
                fillSpace(TAB, number.length(), ".");
            }
            System.out.println(TABLE_COLOR + "\u2503" + RESET);
        }
    }

    private void printHeroesNames() {
        for (Hero h : heroes) {
            System.out.print(TABLE_COLOR + "\u2503" + RESET);
            String name = h.getName();
            System.out.print("Name");
            fillSpace(2 * TAB, 4, ".");
            System.out.print(name);
            fillSpace(TAB, name.length(), ".");
        }
        System.out.println(TABLE_COLOR + "\u2503" + RESET);// ┃
    }

    private void printHeroesRace() {
        for (Hero h : heroes) {
            System.out.print(TABLE_COLOR + "\u2503" + RESET);
            String race = h.getRv().name;
            System.out.print("Race");
            fillSpace(2 * TAB, 4, ".");
            System.out.print(race);
            fillSpace(TAB, race.length(), ".");
        }
        System.out.println(TABLE_COLOR + "\u2503" + RESET);
    }

    private void printLeader() {
        for (Hero h : heroes) {
            System.out.print(TABLE_COLOR + "\u2503" + RESET);
            boolean leader = h.isLeader();
            System.out.print(leader ? "Leader!!" : "");
            fillSpace(2 * TAB, leader ? 8 : 0, ".");
            fillSpace(TAB, 0, ".");
        }
        System.out.println(TABLE_COLOR + "\u2503" + RESET);
    }

    private void printLine(String start, String middle, String end) {
        System.out.print(start);
        for (int i = 0; i < heroes.size() - 1; i++) {
            fillSpace(3 * TAB, 0, "\u2501");    // ━
            System.out.print(middle);
        }
        fillSpace(3 * TAB, 0, "\u2501");
        System.out.println(end);
    }

    /////////////////////////////////end print heroes table/////////////////////////////////////////////////////////////
    private void upgradeHeroes() {
        for (Hero h : heroes) {
            while (h.getPoints() > 0) {
                System.out.print(BLUE + "upgrade hero:" + YELLOW + h.getName() + " " + h.getRv().name + BLUE);
                System.out.println(" you have " + PURPLE + h.getPoints() + BLUE + " points" + RESET);
                h.printMainParameters();
                int i = Validator.getNumber("enter your variant", 1, GameConstants.parametersNames.length);
                int a = Validator.getNumber("enter quantity", 1, h.getPoints());
                h.incPoints(-1 * a);
                i += 3;
                int i2 = a + h.getParametersNumbers().get(i);
                h.getParametersNumbers().set(i, i2);
            }
        }
    }

    private void setLeader(int i) {
        heroes.get(i - 1).setLeader(true);
    }

}
