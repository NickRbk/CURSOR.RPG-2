package cursor.rybak.model.hero.elf.mage.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.elf.ElfAbility;

public class FrostBolt extends AbstractAbility {

    public FrostBolt() {
        super(ElfAbility.FROST_BOLT.getName(), ElfAbility.FROST_BOLT.getEnergyConsumption(),
                ElfAbility.FROST_BOLT.getDamage(), ElfAbility.FROST_BOLT.getCoolDown());
    }

    @Override
    public void specialAbility() {
    }
}
