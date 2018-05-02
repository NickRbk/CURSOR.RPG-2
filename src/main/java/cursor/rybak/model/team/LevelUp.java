package cursor.rybak.model.team;

import cursor.rybak.model.race.AbstractRace;

import java.util.List;

public interface LevelUp {
    default int levelUpPoints(List<AbstractRace> heroes, int prevLevelPoints) {
        int levelsSum = LevelMathUtil.getSum(heroes);

        return prevLevelPoints * (100 - levelsSum) / 100 + prevLevelPoints;
    }
}
