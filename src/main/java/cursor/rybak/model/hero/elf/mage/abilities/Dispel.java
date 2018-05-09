package cursor.rybak.model.hero.elf.mage.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.elf.ElfAbility;

public class Dispel extends AbstractAbility {

    public Dispel() {
        super(ElfAbility.DISPEL.getName(), ElfAbility.DISPEL.getEnergyConsumption(),
                ElfAbility.DISPEL.getDamage(), ElfAbility.DISPEL.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // implement dispel any spell
    }
}
