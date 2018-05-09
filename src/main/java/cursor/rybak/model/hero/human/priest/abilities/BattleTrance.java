package cursor.rybak.model.hero.human.priest.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.human.HumanAbility;

public class BattleTrance extends AbstractAbility {

    public BattleTrance() {
        super(HumanAbility.BATTLE_TRANCE.getName(), HumanAbility.BATTLE_TRANCE.getEnergyConsumption(),
                HumanAbility.BATTLE_TRANCE.getDamage(), HumanAbility.BATTLE_TRANCE.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // implement gain immunity for next turn
    }
}
