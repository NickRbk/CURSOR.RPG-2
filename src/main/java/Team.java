
import java.io.IOException;
import java.util.ArrayList;

import character.Hero;
import lombok.Getter;
import lombok.Setter;
import util.Colors;
import util.Validation;


import static util.Console.fillSpace;
import static util.Console.TAB;

class Team {
    @Setter
    @Getter
    private int position;
    @Getter
    private ArrayList<Hero> heroes;

    Team() {
        heroes = new ArrayList<>();
        position = 0;
    }

    void addHero(String race, String speciality, int id, int spec) throws IOException {
        heroes.add(new Hero(race, speciality, id, spec));
    }

    //////////////////  print heroes table /////////////////////////////////////////////////////////////////////////////
    void printTeam(String c, String r) {
        printLine(c+"\u250F", "\u2533", "\u2513"+r);
        printHeroesNames(c, r);
        printHeroesRace(c, r);
        printLine(c+"\u2523", "\u254B", "\u252B"+r);
        printHeroesParameters(c, r);
        printLeader(c, r);
        printLine(c+"\u2517", "\u253B", "\u251B"+r);
    }

    private void printHeroesParameters(String c, String r) {
        for (int j = 0; j < heroes.get(0).getParametersNames().size(); j++) {
            for (int i = 0; i < heroes.size(); i++) {
                System.out.print(c+"\u2503"+r);
                String name = heroes.get(i).getParametersNames().get(j);
                String number = heroes.get(i).getParametersNumbers().get(j);
                System.out.print(name);
                fillSpace(2 * TAB, name.length(), ".");
                System.out.print(number);
                fillSpace(TAB, number.length(), ".");
            }
            System.out.println(c+"\u2503"+r);
        }
    }

    private void printHeroesNames(String c, String r) {
        for (int i = 0; i < heroes.size(); i++) {
            System.out.print(c+"\u2503"+r);
            String name = heroes.get(i).getName();
            System.out.print("Name");
            fillSpace(2 * TAB, 4, ".");
            System.out.print(name);
            fillSpace(TAB, name.length(), ".");
        }
        System.out.println(c+"\u2503"+r);// ┃
    }

    private void printHeroesRace(String c, String r) {
        for (int i = 0; i < heroes.size(); i++) {
            System.out.print(c+"\u2503"+r);
            String race = heroes.get(i).getRace();
            System.out.print("Race");
            fillSpace(2 * TAB, 4, ".");
            System.out.print(race);
            fillSpace(TAB, race.length(), ".");
        }
        System.out.println(c+"\u2503"+r);
    }

    private void printLeader(String c, String r) {
        for (int i = 0; i < heroes.size(); i++) {
            System.out.print(c+"\u2503"+r);
            boolean leader = heroes.get(i).isLeader();
            System.out.print(leader ? "Leader!!" : "");
            fillSpace(2 * TAB, leader ? 8 : 0, ".");
            fillSpace(TAB, 0, ".");
        }
        System.out.println(c+"\u2503"+r);
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
    public void upgradeHeroes(){
        for(Hero h:heroes){
            while(h.getPoints()>0){
                System.out.print(Colors.BLUE+"upgrade hero:"+Colors.YELLOW+h.getName()+" "+h.getRace()+Colors.BLUE);
                System.out.println(" you have "+Colors.PURPLE+h.getPoints()+Colors.BLUE+" points"+Colors.RESET);
                h.printMainParameters();
                int i=Validation.getNumber("enter your variant",1,h.getParametersNames().size()-4);
                int a=Validation.getNumber("enter quantity",1,h.getPoints());
                h.incPoints(-1*a);
                i+=3;
                int i2=a+Integer.parseInt(h.getParametersNumbers().get(i));
                h.getParametersNumbers().set(i,Integer.toString(i2));
            }
        }
    }

    void setLeader(int i) {
        heroes.get(i - 1).setLeader(true);
    }

}
