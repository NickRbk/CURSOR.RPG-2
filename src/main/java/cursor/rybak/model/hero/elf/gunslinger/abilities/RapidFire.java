package cursor.rybak.model.hero.elf.gunslinger.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.elf.ElfAbility;

public class RapidFire extends AbstractAbility {

    public RapidFire() {
        super(ElfAbility.RAPID_FIRE.getName(), ElfAbility.RAPID_FIRE.getEnergyConsumption(),
                ElfAbility.RAPID_FIRE.getDamage(), ElfAbility.RAPID_FIRE.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // implement attack single target
        // with one additional attack
    }
}
