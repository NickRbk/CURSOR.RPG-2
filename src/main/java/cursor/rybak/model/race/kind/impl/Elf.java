package cursor.rybak.model.race.kind.impl;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.race.kind.Races;

import java.util.Map;

public class Elf extends AbstractRace {

    public Elf(String heroName) {
        super(Races.ELF.getName(), heroName, Races.ELF.getCharisma(), Races.ELF.getStamina(),
                Races.ELF.getIntellect(), Races.ELF.getAgility(), Races.ELF.getConcentration());
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
