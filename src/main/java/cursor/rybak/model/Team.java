package cursor.rybak.model;

import cursor.rybak.model.character.Hero;
import cursor.rybak.model.character.RacesVariants;
import cursor.rybak.model.character.Specialities;
import cursor.rybak.util.Colors;
import cursor.rybak.util.GameConstants;
import cursor.rybak.util.Validator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Team implements Colors, GameConstants {
    @Getter
    private List<Hero> heroes = new ArrayList<>();

    public Team() {
    }

    public void createTeam() {
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
        printLine(GameConstants.TABLE_COLOR + "\u250F", "\u2533", "\u2513" + Colors.RESET);
        printHeroesNames();
        printHeroesRace();
        printLine(GameConstants.TABLE_COLOR + "\u2523", "\u254B", "\u252B" + Colors.RESET);
        printHeroesParameters();
        printLeader();
        printLine(GameConstants.TABLE_COLOR + "\u2517", "\u253B", "\u251B" + Colors.RESET);
    }

    private void printHeroesParameters() {
        for (int j = 0; j < GameConstants.parametersNames.length; j++) {
            for (Hero h : heroes) {
                System.out.print(GameConstants.TABLE_COLOR + "\u2503" + Colors.RESET);
                String name = GameConstants.parametersNames[j];
                String number = Double.toString(h.getParametersNumbers().get(j));
                System.out.print(name);
                System.out.print(number);
            }
            System.out.println(GameConstants.TABLE_COLOR + "\u2503" + Colors.RESET);
        }
    }

    private void printHeroesNames() {
        for (Hero h : heroes) {
            System.out.print(GameConstants.TABLE_COLOR + "\u2503" + Colors.RESET);
            String name = h.getName();
            System.out.print("Name");
            System.out.print(name);
        }
        System.out.println(GameConstants.TABLE_COLOR + "\u2503" + Colors.RESET);// ┃
    }

    private void printHeroesRace() {
        for (Hero h : heroes) {
            System.out.print(GameConstants.TABLE_COLOR + "\u2503" + Colors.RESET);
            String race = h.getRv().name;
            System.out.print("Race");
            System.out.print(race);
        }
        System.out.println(GameConstants.TABLE_COLOR + "\u2503" + Colors.RESET);
    }

    private void printLeader() {
        for (Hero h : heroes) {
            System.out.print(GameConstants.TABLE_COLOR + "\u2503" + Colors.RESET);
            boolean leader = h.isLeader();
            System.out.print(leader ? "Leader!!" : "");
        }
        System.out.println(GameConstants.TABLE_COLOR + "\u2503" + Colors.RESET);
    }

    private void printLine(String start, String middle, String end) {
        System.out.print(start);
        for (int i = 0; i < heroes.size() - 1; i++) {
            System.out.print(middle);
        }
        System.out.println(end);
    }

    /////////////////////////////////end print heroes table/////////////////////////////////////////////////////////////
    private void upgradeHeroes() {
        for (Hero h : heroes) {
            while (h.getPoints() > 0) {
                System.out.print(Colors.BLUE + "upgrade hero:" + Colors.YELLOW + h.getName() + " " + h.getRv().name + Colors.BLUE);
                System.out.println(" you have " + Colors.PURPLE + h.getPoints() + Colors.BLUE + " points" + Colors.RESET);
                h.printMainParameters();
                int i = Validator.getNumber("enter your variant", 1, GameConstants.parametersNames.length);
                int a = Validator.getNumber("enter quantity", 1, h.getPoints());
                h.incPoints(-1 * a);
                int i2 = a + h.getParametersNumbers().get(i);
                h.getParametersNumbers().set(i, i2);
            }
        }
    }

    private void setLeader(int i) {
        heroes.get(i - 1).setLeader(true);
    }

}
