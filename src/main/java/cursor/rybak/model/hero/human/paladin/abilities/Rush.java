package cursor.rybak.model.hero.human.paladin.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.human.HumanAbility;

public class Rush extends AbstractAbility {

    public Rush() {
        super(HumanAbility.RUSH.getName(), HumanAbility.RUSH.getEnergyConsumption(),
                HumanAbility.RUSH.getDamage(), HumanAbility.RUSH.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // implement dashes to nearest enemy
        // to deal additional [2;6] damage
    }
}
