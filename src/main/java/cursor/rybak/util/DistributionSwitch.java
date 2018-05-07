package cursor.rybak.util;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.race.Characteristics;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DistributionSwitch {
    private static DistributionSwitch instance;

    @Getter
    private Map<String, BiConsumer<AbstractRace, Integer>> characteristicsSwitch;

    private DistributionSwitch() {
        this.characteristicsSwitch = generateCharacteristicsSwitch();
    }

    public static DistributionSwitch getInstance() {
        if (instance == null) {
            instance = new DistributionSwitch();
        }

        return instance;
    }

    private Map<String, BiConsumer<AbstractRace, Integer>> generateCharacteristicsSwitch() {
        Map<String, BiConsumer<AbstractRace, Integer>> map = new HashMap<>();

        map.put(Characteristics.CHARISMA, this::setCharisma);
        map.put(Characteristics.STAMINA, this::setStamina);
        map.put(Characteristics.INTELLECT, this::setIntellect);
        map.put(Characteristics.AGILITY, this::setAgility);
        map.put(Characteristics.CONCENTRATION, this::setConcentration);

        return map;
    }

    private void setCharisma(AbstractRace hero, Integer points) {
        hero.setCharisma(points);
    }

    private void setStamina(AbstractRace hero, Integer points) {
        hero.setStamina(points);
    }

    private void setIntellect(AbstractRace hero, Integer points) {
        hero.setIntellect(points);
    }

    private void setAgility(AbstractRace hero, Integer points) {
        hero.setAgility(points);
    }

    private void setConcentration(AbstractRace hero, Integer points) {
        hero.setConcentration(points);
    }
}
