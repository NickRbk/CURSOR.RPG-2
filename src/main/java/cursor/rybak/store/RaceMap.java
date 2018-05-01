package cursor.rybak.store;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.race.kind.Races;
import cursor.rybak.store.components.DwarfHeroesMap;
import cursor.rybak.store.components.ElfHeroesMap;
import cursor.rybak.store.components.HumanHeroesMap;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class RaceMap {
    private static RaceMap instance;

    private HumanHeroesMap humanHeroesMap;
    private ElfHeroesMap elfHeroesMap;
    private DwarfHeroesMap dwarfHeroesMap;

    @Getter
    private Map<String, Map<String, Supplier<AbstractRace>>> raceMap;

    private RaceMap() {
        this.humanHeroesMap = new HumanHeroesMap();
        this.elfHeroesMap = new ElfHeroesMap();
        this.dwarfHeroesMap = new DwarfHeroesMap();

        this.raceMap = generateRaceMap();
    }

    public static RaceMap getInstance() {
        if (instance == null) {
            instance = new RaceMap();
        }

        return instance;
    }

    private Map<String, Map<String, Supplier<AbstractRace>>> generateRaceMap() {
        Map<String, Map<String, Supplier<AbstractRace>>> races = new LinkedHashMap<>();

        races.put(Races.Human.getName(), humanHeroesMap.getHumanHeroes());
        races.put(Races.Elf.getName(), elfHeroesMap.getElfHeroes());
        races.put(Races.Dwarf.getName(), dwarfHeroesMap.getDwarfHeroes());

        return races;
    }
}
