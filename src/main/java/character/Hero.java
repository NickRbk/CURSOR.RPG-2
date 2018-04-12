package character;

import lombok.Getter;
import lombok.Setter;
import util.Console;
import util.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Hero {
    @Getter
    private boolean isLeader;
    @Getter
    @Setter
    private int points;
    @Getter
    private String name;
    private int raceId;
    @Getter
    private String race;
    private String speciality;
    @Getter
    private ArrayList<String> parametersNames;
    @Getter
    private ArrayList<String> parametersNumbers;
    private Map<String, String> specialities;

    public Hero(String race, String speciality, int param, int spec) throws IOException {
        parametersNames = new ArrayList<>();
        parametersNumbers= new ArrayList<>();
        specialities = new LinkedHashMap<>();
        raceId = param;
        isLeader = false;
        this.race = race;
        this.speciality = speciality;
        setParameters(param);
        setSpecialty(spec);
        setName();
        points = 10;
    }

    private void setParameters(int param) throws IOException {
        List<String> p = Reader.readFile("Race" + param + "p");
        for (int i = 0; i < p.size() / 2; i++) {
            parametersNames.add(p.get(i * 2));
            parametersNumbers.add(p.get(i * 2 + 1));
        }

    }

    private void setSpecialty(int spec) throws IOException {
        List<String> p = Reader.readFile("Race" + raceId);
        specialities.put(p.get((spec - 1) * 2), p.get((spec - 1) * 2 + 1));
    }

    public void printHeroInfo() {
        System.out.println("----------------------------------------");
        System.out.print("Name");
        Console.fillSpace(2 * Console.TAB, 4,".");
        System.out.println(name);
        System.out.print("Race");
        Console.fillSpace(2 * Console.TAB, 4,".");
        System.out.println(race);
        System.out.println("parameters:");
        printParameters();
        printSpecialities();
        System.out.println(isLeader ? "Leader!!" : "");
    }

    private void printParameters() {
        for (int i=0;i<parametersNumbers.size();i++) {
            System.out.print(parametersNames.get(i));
            Console.fillSpace(2 * Console.TAB, parametersNames.get(i).length(),".");
            System.out.println(parametersNumbers.get(i));
        }
    }

    private void printSpecialities() {
        System.out.println("specialities:");
        for (Entry<String, String> entry : specialities.entrySet()) {
            System.out.print(entry.getKey());
            Console.fillSpace(2 * Console.TAB, entry.getKey().length(),".");
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
