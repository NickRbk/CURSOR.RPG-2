package cursor.rybak.store;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.race.kind.Races;
import cursor.rybak.store.components.DwarfHeroesMap;
import cursor.rybak.store.components.ElfHeroesMap;
import cursor.rybak.store.components.HumanHeroesMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class RaceMap {
    public static Map<String, Map<String, AbstractRace>> getRace() {
        Map<String, Map<String, AbstractRace>> races = new LinkedHashMap<>();

        races.put(Races.Human.getName(), HumanHeroesMap.getHumanHeroes());
        races.put(Races.Elf.getName(), ElfHeroesMap.getElfHeroes());
        races.put(Races.Dwarf.getName(), DwarfHeroesMap.getDwarfHeroes());

        return races;
    }
}
