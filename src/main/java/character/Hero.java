package character;

import util.Console;
import util.Reader;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Hero {
    private boolean isLeader;
    private String name;
    private int raceId;
    private String race;
    private String speciality;
    private Map<String, Integer> parameters;
    private Map<String, String> specialities;

    public Hero(String race, String specialitie, int param, int spec) throws IOException {
        parameters = new LinkedHashMap<>();
        specialities = new LinkedHashMap<>();
        raceId = param;
        isLeader = false;
        this.race = race;
        this.speciality = specialitie;
        setParameters(param);
        setSpecialty(spec);
        setName();
    }

    private void setParameters(int param) throws IOException {
        List<String> p = Reader.readFile("Race" + param + "p");
        for (int i = 0; i < p.size() / 2; i++) {
            parameters.put(p.get(i * 2), Integer.parseInt(p.get(i * 2 + 1)));
        }
    }

    private void setSpecialty(int s) throws IOException {
        List<String> p = Reader.readFile("Race" + raceId);
        specialities.put(p.get((s - 1) * 2), p.get((s - 1) * 2 + 1));
    }

    public void printHeroInfo() {
        System.out.println("----------------------------------------");
        System.out.print("Name");
        Console.fillSpace(15, 4);
        System.out.println(name);
        System.out.print("Race");
        Console.fillSpace(15, 4);
        System.out.println(race);
        System.out.println("parameters:");
        printParametres();
        printSpecialities();
        System.out.println(isLeader ? "Leader!!" : "");
    }

    private void printParametres() {
        for (Map.Entry<String, Integer> entry : parameters.entrySet()) {
            System.out.print(entry.getKey());
            Console.fillSpace(15, entry.getKey().length());
            System.out.println(entry.getValue());
        }
    }

    private void printSpecialities() {
        System.out.println("specialities:");
        for (Map.Entry<String, String> entry : specialities.entrySet()) {
            System.out.print(entry.getKey());
            Console.fillSpace(15, entry.getKey().length());
            System.out.println(entry.getValue());
        }
    }

    private void setName() throws IOException {
        List<String> info = Reader.readFile("names");
        name = info.get((int) (Math.random() * 10 + 10 * raceId - 9));
    }

    public void printInfo() {
        System.out.println(race + " " + speciality);
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }
}
