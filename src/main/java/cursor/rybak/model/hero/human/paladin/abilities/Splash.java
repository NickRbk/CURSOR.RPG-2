package cursor.rybak.model.hero.human.paladin.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.human.HumanAbility;

public class Splash extends AbstractAbility {

    public Splash() {
        super(HumanAbility.SPLASH.getName(), HumanAbility.SPLASH.getEnergyConsumption(),
                HumanAbility.SPLASH.getDamage(), HumanAbility.SPLASH.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // implement attack 2 additional targets
    }
}
