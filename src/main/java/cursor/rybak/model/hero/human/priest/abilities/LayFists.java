package cursor.rybak.model.hero.human.priest.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.human.HumanAbility;

public class LayFists extends AbstractAbility {
    public LayFists() {
        super(HumanAbility.LAY_OF_FISTS.getName(), HumanAbility.LAY_OF_FISTS.getEnergyConsumption(),
                HumanAbility.LAY_OF_FISTS.getDamage(), HumanAbility.LAY_OF_FISTS.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // hit multiple targets (from 2 to 3)
    }
}
