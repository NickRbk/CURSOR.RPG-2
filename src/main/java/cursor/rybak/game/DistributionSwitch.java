package cursor.rybak.game;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.race.Characteristics;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DistributionSwitch {
    public Map<String, Function<Map<AbstractRace, Integer>, Boolean>> getCharacteristicsSwitch() {
        Map<String, Function<Map<AbstractRace, Integer>, Boolean>> map = new HashMap<>();

        map.put(Characteristics.CHARISMA, this::setCharisma);
        map.put(Characteristics.STAMINA, this::setStamina);
        map.put(Characteristics.INTELLECT, this::setIntellect);
        map.put(Characteristics.AGILITY, this::setAgility);
        map.put(Characteristics.CONCENTRATION, this::setConcentration);

        return map;
    }

    private Boolean setCharisma(Map<AbstractRace, Integer> map) {
        map.forEach(AbstractRace::setCharisma);
        return true;
    }

    private Boolean setStamina(Map<AbstractRace, Integer> map) {
        map.forEach(AbstractRace::setStamina);
        return true;
    }

    private Boolean setIntellect(Map<AbstractRace, Integer> map) {
        map.forEach(AbstractRace::setIntellect);
        return true;
    }

    private Boolean setAgility(Map<AbstractRace, Integer> map) {
        map.forEach(AbstractRace::setAgility);
        return true;
    }

    private Boolean setConcentration(Map<AbstractRace, Integer> map) {
        map.forEach(AbstractRace::setConcentration);
        return true;
    }
}
