package cursor.rybak.store.heroes.components;

import cursor.rybak.model.hero.dwarf.mechanist.Mechanist;
import cursor.rybak.model.hero.dwarf.warrior.Warrior;
import cursor.rybak.model.race.AbstractRace;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DwarfMap {
    public Map<String, Supplier<AbstractRace>> getDwarfHeroes() {
        Map<String, Supplier<AbstractRace>> raceHeroes = new LinkedHashMap<>();

        raceHeroes.put("warrior", this::createWarrior);
        raceHeroes.put("mechanist", this::createMechanist);

        return raceHeroes;
    }

    private AbstractRace createWarrior() {
        return new Warrior();
    }

    private AbstractRace createMechanist() {
        return new Mechanist();
    }
}
