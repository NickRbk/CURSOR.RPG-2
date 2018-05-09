package cursor.rybak.model.hero.dwarf.mechanist.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.dwarf.DwarfAbility;

public class Bombs extends AbstractAbility {

    public Bombs() {
        super(DwarfAbility.BOMBS.getName(), DwarfAbility.BOMBS.getEnergyConsumption(),
                DwarfAbility.BOMBS.getDamage(), DwarfAbility.BOMBS.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // implement throw a bomb that hits 2 enemies
    }
}
