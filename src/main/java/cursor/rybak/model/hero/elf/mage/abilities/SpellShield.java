package cursor.rybak.model.hero.elf.mage.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.elf.ElfAbility;

public class SpellShield extends AbstractAbility {

    public SpellShield() {
        super(ElfAbility.SPELL_SHIELD.getName(), ElfAbility.SPELL_SHIELD.getEnergyConsumption(),
                ElfAbility.SPELL_SHIELD.getDamage(), ElfAbility.SPELL_SHIELD.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // implement block 60 dmg till destruction
    }
}
