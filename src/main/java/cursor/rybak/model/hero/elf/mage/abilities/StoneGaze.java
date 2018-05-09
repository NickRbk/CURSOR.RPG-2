package cursor.rybak.model.hero.elf.mage.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.elf.ElfAbility;

public class StoneGaze extends AbstractAbility {

    public StoneGaze() {
        super(ElfAbility.STONE_GAZE.getName(), ElfAbility.STONE_GAZE.getEnergyConsumption(),
                ElfAbility.STONE_GAZE.getDamage(), ElfAbility.STONE_GAZE.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // implement transform enemy into stone
        // for 2 turns
    }
}
