package cursor.rybak.model;

import cursor.rybak.model.character.Hero;
import cursor.rybak.model.character.RacesVariants;
import cursor.rybak.model.character.Specialities;
import cursor.rybak.util.GameConstants;
import cursor.rybak.util.Validator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Team implements GameConstants {
    @Getter
    private List<Hero> heroes = new ArrayList<>();

    public Team() {
    }

    public void createTeam() {
        for (int i = 0; i < 3; i++) {
            chooseHero();
        }
        chooseLeader();
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
        System.out.println("choose race: ");
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

    private void upgradeHeroes() {
        for (Hero h : heroes) {
            while (h.getPoints() > 0) {
                System.out.print("upgrade hero: " + h.getName() + " " + h.getRv().name);
                System.out.println(" you have " + h.getPoints() + " points");
                h.printMainParameters();
                int i = Validator.getNumber("enter your variant: ", 1, GameConstants.parametersNames.length);
                int a = Validator.getNumber("enter quantity: ", 1, h.getPoints());
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
