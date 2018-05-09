package cursor.rybak.model.hero.dwarf.mechanist.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.dwarf.DwarfAbility;

public class DroidArms extends AbstractAbility {

    public DroidArms() {
        super(DwarfAbility.DROID_ARMS.getName(), DwarfAbility.DROID_ARMS.getEnergyConsumption(),
                DwarfAbility.DROID_ARMS.getDamage(), DwarfAbility.DROID_ARMS.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // implement create droid that attack random enemy
        // lasts 3 turns, has 50 HP
    }
}
