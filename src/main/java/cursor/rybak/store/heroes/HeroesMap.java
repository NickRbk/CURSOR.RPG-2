package cursor.rybak.store.heroes;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.race.kind.Races;
import cursor.rybak.store.heroes.components.DwarfMap;
import cursor.rybak.store.heroes.components.ElfMap;
import cursor.rybak.store.heroes.components.HumanMap;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class HeroesMap {
    private static HeroesMap instance;

    private HumanMap humanMap;
    private ElfMap elfMap;
    private DwarfMap dwarfMap;

    @Getter
    private Map<String, Map<String, Supplier<AbstractRace>>> raceMap;

    private HeroesMap() {
        this.humanMap = new HumanMap();
        this.elfMap = new ElfMap();
        this.dwarfMap = new DwarfMap();

        this.raceMap = generateRaceMap();
    }

    public static HeroesMap getInstance() {
        if (instance == null) {
            instance = new HeroesMap();
        }

        return instance;
    }

    private Map<String, Map<String, Supplier<AbstractRace>>> generateRaceMap() {
        Map<String, Map<String, Supplier<AbstractRace>>> races = new LinkedHashMap<>();

        races.put(Races.HUMAN.getName(), humanMap.getHumanHeroes());
        races.put(Races.ELF.getName(), elfMap.getElfHeroes());
        races.put(Races.DWARF.getName(), dwarfMap.getDwarfHeroes());

        return races;
    }
}
