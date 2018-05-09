package cursor.rybak.model.hero.dwarf.warrior.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.dwarf.DwarfAbility;

public class StandGround extends AbstractAbility {

    public StandGround() {
        super(DwarfAbility.STAND_GROUND.getName(), DwarfAbility.STAND_GROUND.getEnergyConsumption(),
                DwarfAbility.STAND_GROUND.getDamage(), DwarfAbility.STAND_GROUND.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // implement gain 50 HP shield for 2 turns
    }
}
