package character;

import lombok.Getter;
import lombok.Setter;
import util.Colors;
import util.Console;
import util.GameConstants;
import java.util.ArrayList;

public class Hero implements Colors {
    @Getter
    private boolean isLeader;
    @Getter
    @Setter
    private int points;
    @Getter
    private String name;
    @Getter
    private String race;
    private String speciality;
    RacesVariants rv;
    @Getter
    ArrayList <Integer>parametersNumbers=new ArrayList<>();
    Specialities spec;


    public Hero(RacesVariants rv, Specialities spec) {
        isLeader = false;
        this.spec = spec;
        setParameters(rv);
        this.rv=rv;
        setName();
        points = 10;
    }

    private void setParameters(RacesVariants rv) {
        this.race = rv.name;
        parametersNumbers.add(rv.charisma);
        parametersNumbers.add(rv.stamina);
        parametersNumbers.add(rv.intellect);
        parametersNumbers.add(rv.agility);
        parametersNumbers.add(rv.concentration);
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
            System.out.print(GameConstants.parametersNames[i]);
            Console.fillSpace(2 * Console.TAB, GameConstants.parametersNames[i].length(),".");
            System.out.println(parametersNumbers.get(i));
        }
    }

    private void printSpecialities() {
        System.out.println("speciality:");
            System.out.print(spec.name);
            Console.fillSpace(2 * Console.TAB, spec.name.length(),".");
            System.out.println(spec.description);
    }

    private void setName(){
        name = HeroNames.valueOf(rv.name()+"NAME"+(int) (Math.random() * 10)).name;
    }

    public void printInfo() {
        System.out.print(race + " " + speciality);
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }
    public void incPoints(int i){
        points+=i;
    }
    public void printMainParameters(){
        System.out.print(GREEN+"[0 : info] "+RESET);
        for(int i=0;i<GameConstants.parametersNames.length;i++){
            System.out.print(GREEN+"["+(i+1)+": "+GameConstants.parametersNames[i]+
                    " "+parametersNumbers.get(i)+"] "+RESET);
        }
        System.out.println();
    }
}
