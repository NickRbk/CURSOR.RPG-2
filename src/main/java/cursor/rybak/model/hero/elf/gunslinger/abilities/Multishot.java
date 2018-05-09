package cursor.rybak.model.hero.elf.gunslinger.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.elf.ElfAbility;

public class Multishot extends AbstractAbility {

    public Multishot() {
        super(ElfAbility.MULTISHOT.getName(), ElfAbility.MULTISHOT.getEnergyConsumption(),
                ElfAbility.MULTISHOT.getDamage(), ElfAbility.MULTISHOT.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // implement attack one additional target
    }
}
