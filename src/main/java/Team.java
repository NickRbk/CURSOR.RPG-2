
import java.io.IOException;
import java.util.ArrayList;

import character.Hero;
import lombok.Getter;
import lombok.Setter;

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

    void printTeam() {
        for (Hero h : heroes) {
            h.printHeroInfo();
        }
    }

    //////////////////  print heroes table /////////////////////////////////////////////////////////////////////////////
    void printTeam2() {
        printLine("\u250F","\u2533","\u2513");
        printHeroesNames();
        printHeroesRace();
        printLine("\u2523","\u254B","\u252B");
        printHeroesParameters();
        printLeader();
        printLine("\u2517","\u253B","\u251B");
    }

    private void printHeroesParameters(){
        for (int j = 0; j < heroes.get(0).getParametersNames().size(); j++){
            for (int i = 0; i < heroes.size(); i++) {
                System.out.print("\u2503");
                String name=heroes.get(i).getParametersNames().get(j);
                String number=heroes.get(i).getParametersNumbers().get(j);
                System.out.print(name);
                fillSpace(2*TAB,name.length(),".");
                System.out.print(number);
                fillSpace(TAB,number.length(),".");
            }
            System.out.println("\u2503");
        }
    }
    private void printHeroesNames(){
        for (int i = 0; i < heroes.size(); i++){
            System.out.print("\u2503");
            String name=heroes.get(i).getName();
            System.out.print("Name");
            fillSpace(2*TAB,4,".");
            System.out.print(name);
            fillSpace(TAB,name.length(),".");
        }
        System.out.println("\u2503");// ┃
    }

    private void printHeroesRace(){
        for (int i = 0; i < heroes.size(); i++){
            System.out.print("\u2503");
            String race=heroes.get(i).getRace();
            System.out.print("Race");
            fillSpace(2*TAB,4,".");
            System.out.print(race);
            fillSpace(TAB,race.length(),".");
        }
        System.out.println("\u2503");
    }
    private void printLeader(){
        for (int i = 0; i < heroes.size(); i++){
            System.out.print("\u2503");
            boolean leader=heroes.get(i).isLeader();
            System.out.print(leader?"Leader!!":"");
            fillSpace(2*TAB,leader?8:0,".");
            fillSpace(TAB,0,".");
        }
        System.out.println("\u2503");
    }

    private void printLine(String start,String middle, String end){
        System.out.print(start);
        for (int i = 0; i < heroes.size()-1; i++){
            fillSpace(3*TAB,0,"\u2501");    // ━
            System.out.print(middle);
        }
        fillSpace(3*TAB,0,"\u2501");
        System.out.println(end);
    }
    /////////////////////////////////end print heroes table/////////////////////////////////////////////////////////////

    void setLeader(int i) {
        heroes.get(i - 1).setLeader(true);
    }

}
