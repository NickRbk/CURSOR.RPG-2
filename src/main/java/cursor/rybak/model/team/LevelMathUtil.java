package cursor.rybak.model.team;

import cursor.rybak.model.race.AbstractRace;

import java.util.List;

public class LevelMathUtil {
    public static int getSum( List<AbstractRace> heroes) {
        return heroes.stream()
                .map(AbstractRace::getLevel)
                .reduce((lvl1, lvl2) -> lvl1 + lvl2)
                .orElse(0);
    }

    public static double getAverage(List<AbstractRace> heroes) {
        int levelsSum = getSum(heroes);
        return Math.ceil( (double)levelsSum / heroes.size() );
    }
}
