import java.io.IOException;
import java.util.ArrayList;

import Character.Hero;

class Team {
    private ArrayList<Hero> heroes;

    Team() {
        heroes = new ArrayList<>();
    }

    void addHero(String race, String speciality, int id, int s) throws IOException {
        heroes.add(new Hero(race, speciality, id, s));
    }

    void printTeam() {
        for (Hero h : heroes) {
            h.printHeroInfo();
        }
    }

    ArrayList<Hero> getHeroes() {
        return heroes;
    }

    void setLeader(int i) {
        heroes.get(i - 1).setLeader(true);
    }
}
