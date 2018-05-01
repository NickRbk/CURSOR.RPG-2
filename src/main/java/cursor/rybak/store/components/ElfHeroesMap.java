package cursor.rybak.store.components;

import cursor.rybak.model.hero.elf.gunslinger.Gunslinger;
import cursor.rybak.model.hero.elf.mage.Mage;
import cursor.rybak.model.race.AbstractRace;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ElfHeroesMap {
    public Map<String, Supplier<AbstractRace>> getElfHeroes() {
        Map<String, Supplier<AbstractRace>> raceHeroes = new LinkedHashMap<>();

        raceHeroes.put("mage", this::createMage);
        raceHeroes.put("gunslinger", this::createGunslinger);

        return raceHeroes;
    }

    private AbstractRace createMage() {
        return new Mage();
    }

    private AbstractRace createGunslinger() {
        return new Gunslinger();
    }
}
