package cursor.rybak.model.hero.human.priest.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.human.HumanAbility;

public class HandGod extends AbstractAbility {

    public HandGod() {
        super(HumanAbility.HAND_OF_GOD.getName(), HumanAbility.HAND_OF_GOD.getEnergyConsumption(),
                HumanAbility.HAND_OF_GOD.getDamage(), HumanAbility.HAND_OF_GOD.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // implement heals 20 hits
        // (can be cast on itself or other unit,
        // if casts on UNDEAD deal damage instead heal)
    }
}
