package cursor.rybak.store.heroes.components;

import cursor.rybak.model.hero.human.HumanProfession;
import cursor.rybak.model.hero.human.paladin.Paladin;
import cursor.rybak.model.hero.human.priest.Priest;
import cursor.rybak.model.race.AbstractRace;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class HumanMap {
    public Map<String, Supplier<AbstractRace>> getHumanHeroes() {
        Map<String, Supplier<AbstractRace>> raceHeroes = new LinkedHashMap<>();

        raceHeroes.put(HumanProfession.PRIEST, this::createPriest);
        raceHeroes.put(HumanProfession.PALADIN, this::createPaladin);

        return raceHeroes;
    }

    private AbstractRace createPriest() {
        return new Priest();
    }

    private AbstractRace createPaladin() {
        return new Paladin();
    }
}
