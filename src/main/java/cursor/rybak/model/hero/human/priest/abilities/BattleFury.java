package cursor.rybak.model.hero.human.priest.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.human.HumanAbility;

public class BattleFury extends AbstractAbility {

    public BattleFury() {
        super(HumanAbility.BATTLE_FURY.getName(), HumanAbility.BATTLE_FURY.getEnergyConsumption(),
                HumanAbility.BATTLE_FURY.getDamage(), HumanAbility.BATTLE_FURY.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // hits every enemy with additional [2;6] damage
    }
}
