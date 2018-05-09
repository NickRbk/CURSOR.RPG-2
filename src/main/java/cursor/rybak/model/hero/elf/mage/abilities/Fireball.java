package cursor.rybak.model.hero.elf.mage.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.elf.ElfAbility;

public class Fireball extends AbstractAbility {

    public Fireball() {
        super(ElfAbility.FIREBALL.getName(), ElfAbility.FIREBALL.getEnergyConsumption(),
                ElfAbility.FIREBALL.getDamage(), ElfAbility.FIREBALL.getCoolDown());
    }

    @Override
    public void specialAbility() {
    }
}
