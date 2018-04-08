package Character;

import Util.Reader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hero {
    private boolean isLeader;
    private int kDamage;
    private float hp;
    private float mp;
    private float rage;
    private int raceId;
    private String race;
    private String specealitie;
    private int lvl;
    private Map<String, Integer> parameters;
    private Map<String, String> specealities;

    public Hero(String race, String specealitie, int param, int spec) throws IOException {
        parameters = new HashMap<>();
        specealities = new HashMap<>();
        raceId = param;
        isLeader = false;
        this.race = race;
        this.specealitie = specealitie;
        lvl = 1;
        setParameters(param);
        setSpecialty(spec);
    }

    private void setParameters(int param) throws IOException {
        List<String> p = Reader.readFile("Race" + param + "p");
        for (int i = 0; i < p.size() / 2; i++) {
            parameters.put(p.get(i * 2), Integer.parseInt(p.get(i * 2 + 1)));
        }
    }

    private void setSpecialty(int s) throws IOException {
        List<String> p = Reader.readFile("Race" + raceId);
        specealities.put(p.get((s - 1) * 2), p.get((s - 1) * 2 + 1));
    }

    public void printHeroInfo() {
        System.out.println("_____________________________________");
        System.out.println("Race: " + race + "\nparametres:");
        for (Map.Entry<String, Integer> entry : parameters.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("specification:");
        for (Map.Entry<String, String> entry : specealities.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println(isLeader ? "Leader!!" : "");
    }

    public void printMainInfo() {
        System.out.println(race + " " + specealitie);
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }
}
