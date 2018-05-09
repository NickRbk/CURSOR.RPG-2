package cursor.rybak.model.hero.elf.gunslinger.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.elf.ElfAbility;

public class BullsEye extends AbstractAbility {

    public BullsEye() {
        super(ElfAbility.BULLS_EYE.getName(), ElfAbility.BULLS_EYE.getEnergyConsumption(),
                ElfAbility.BULLS_EYE.getDamage(), ElfAbility.BULLS_EYE.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // implement archer takes aim and
        // deal critical damage to single target
    }
}
