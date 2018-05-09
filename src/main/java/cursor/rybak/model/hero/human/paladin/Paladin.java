package cursor.rybak.model.hero.human.paladin;

import cursor.rybak.model.common.Damage;
import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.human.HumanProfession;
import cursor.rybak.model.hero.human.paladin.abilities.map.PaladinAbilitiesMap;
import cursor.rybak.model.race.kind.impl.Human;
import lombok.Getter;

import java.util.Map;

public class Paladin extends Human {
    @Getter
    private Map<String, Map<String, AbstractAbility>> specialAttacks = PaladinAbilitiesMap.getSpecialAttackMap();
    @Getter
    private Map<String, Damage> attacks = PaladinAbilitiesMap.getAttackMap();

    public Paladin() {
        super(HumanProfession.PALADIN);
    }

    @Override
    public int attack() {
        return 0;
    }
}
