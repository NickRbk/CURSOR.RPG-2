import java.io.IOException;
import java.util.ArrayList;


import character.Hero;

class Team {
    private ArrayList<Hero> heroes;

    Team() {
        heroes = new ArrayList<>();
    }

    void addHero(String race, String speciality, int id, int spec) throws IOException {
        heroes.add(new Hero(race, speciality, id, spec));
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
