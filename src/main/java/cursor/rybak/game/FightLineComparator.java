package cursor.rybak.game;

import cursor.rybak.model.common.CommonUnit;
import cursor.rybak.model.race.AbstractRace;

import java.util.Comparator;

public class FightLineComparator implements Comparator<CommonUnit> {

    @Override
    public int compare(CommonUnit o1, CommonUnit o2) {

        if (o1.getInitiative() != o2.getInitiative()) {

            return o2.getInitiative() - o1.getInitiative();
        } else if (o1 instanceof AbstractRace != o2 instanceof AbstractRace) {

            if (o1 instanceof AbstractRace) {
                return 1;
            } else return -1;

        } else if (o1.getLevel() != o2.getLevel()) {

            return o2.getLevel() - o1.getLevel();
        } else {

            return (int) (o2.getXp() - o1.getXp());
        }
    }
}
