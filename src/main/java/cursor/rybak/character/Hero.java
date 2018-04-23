package cursor.rybak.character;

import lombok.Getter;
import lombok.Setter;
import cursor.rybak.util.Colors;
import cursor.rybak.util.GameConstants;
import java.util.ArrayList;
import java.util.List;

public class Hero implements Colors {
    @Getter
    private boolean isLeader;
    @Getter
    @Setter
    private int points;
    @Getter
    private String name;
    @Getter
    private RacesVariants rv;
    @Getter
    private List<Integer> parametersNumbers=new ArrayList<>();
    private Specialities spec;


    public Hero(RacesVariants rv, Specialities spec) {
        isLeader = false;
        this.spec = spec;
        setParameters(rv);
        this.rv=rv;
        setName();
        points = 10;
    }

    private void setParameters(RacesVariants rv) {
        parametersNumbers.add(rv.charisma);
        parametersNumbers.add(rv.stamina);
        parametersNumbers.add(rv.intellect);
        parametersNumbers.add(rv.agility);
        parametersNumbers.add(rv.concentration);
    }

    private void setName(){
        name = HeroNames.valueOf(rv.name()+"NAME"+(int) (Math.random() * HeroNames.values().length/3)).name;
    }

    public void printInfo() {
        System.out.print(rv.name + " " + spec.name);
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
