package cursor.rybak.model.race.kind.impl;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.race.kind.Races;

import java.util.Map;

public class Dwarf extends AbstractRace {

    public Dwarf(String heroName) {
        super(Races.DWARF.getName(), heroName, Races.DWARF.getCharisma(), Races.DWARF.getStamina(),
                Races.DWARF.getIntellect(), Races.DWARF.getAgility(), Races.DWARF.getConcentration());
    }

    /**
     * @return int, damage point
     * functionality defined
     * in certain hero
     */
    @Override
    public int attack() {
        return 0;
    }

    @Override
    public Map<String, Map<String, AbstractAbility>> getSpecialAttacks() {
        return null;
    }

    @Override
    public Map<String, int[]> getAttacks() {
        return null;
    }
}
