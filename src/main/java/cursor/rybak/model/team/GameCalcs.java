package cursor.rybak.model.team;

import cursor.rybak.model.race.AbstractRace;

import java.util.Arrays;

public interface GameCalcs {
    default int levelUpPoints(Team team, int prevLevelPoints) {
        int levelsSum = Arrays.stream(team.getHeroes())
                .map(AbstractRace::getLevel)
                .reduce((lvl1, lvl2) -> lvl1 + lvl2)
                .orElse(0);

        return prevLevelPoints * ((100 - levelsSum) / 100) + prevLevelPoints;
    }
}
