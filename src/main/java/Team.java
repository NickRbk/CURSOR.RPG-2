import java.io.IOException;
import java.util.ArrayList;


import character.Hero;

class Team {
    private int position;
    private ArrayList<Hero> heroes;

    Team() {
        heroes = new ArrayList<>();
        position=0;
    }

    void addHero(String race, String speciality, int id, int spec) throws IOException {
        heroes.add(new Hero(race, speciality, id, spec));
    }

    void printTeam() {
        for (Hero h : heroes) {
            h.printHeroInfo();
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    ArrayList<Hero> getHeroes() {
        return heroes;
    }

    void setLeader(int i) {
        heroes.get(i - 1).setLeader(true);
    }
}
