package cursor.rybak.util;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.race.Characteristics;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class DistributionSwitch {
    public Map<String, Consumer<Map<AbstractRace, Integer>>> getCharacteristicsSwitch() {
        Map<String, Consumer<Map<AbstractRace, Integer>>> map = new HashMap<>();

        map.put(Characteristics.CHARISMA, this::setCharisma);
        map.put(Characteristics.STAMINA, this::setStamina);
        map.put(Characteristics.INTELLECT, this::setIntellect);
        map.put(Characteristics.AGILITY, this::setAgility);
        map.put(Characteristics.CONCENTRATION, this::setConcentration);

        return map;
    }

    private void setCharisma(Map<AbstractRace, Integer> map) {
        map.forEach(AbstractRace::setCharisma);
    }

    private void setStamina(Map<AbstractRace, Integer> map) {
        map.forEach(AbstractRace::setStamina);
    }

    private void setIntellect(Map<AbstractRace, Integer> map) {
        map.forEach(AbstractRace::setIntellect);
    }

    private void setAgility(Map<AbstractRace, Integer> map) {
        map.forEach(AbstractRace::setAgility);
    }

    private void setConcentration(Map<AbstractRace, Integer> map) {
        map.forEach(AbstractRace::setConcentration);
    }
}
