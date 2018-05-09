package cursor.rybak.model.hero.human.paladin.abilities.map;

import cursor.rybak.model.common.Damage;
import cursor.rybak.model.common.DamageOption;
import cursor.rybak.model.hero.AbilityType;
import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.human.HumanAbility;
import cursor.rybak.model.hero.human.paladin.abilities.Rush;
import cursor.rybak.model.hero.human.paladin.abilities.Splash;

import java.util.HashMap;
import java.util.Map;

public class PaladinAbilitiesMap {

    /**
     * @return created special attack map
     * with key appropriate key:
     * 'spells' or 'skills'
     */
    public static Map<String, Map<String, AbstractAbility>> getSpecialAttackMap() {
        Map<String, Map<String, AbstractAbility>> specialAttackMap = new HashMap<>();

        specialAttackMap.put(AbilityType.SKILLS, createSkillsMap());

        return specialAttackMap;
    }

    /**
     * @return Map <String, Damage>
     * created map of regular attack
     */
    public static Map<String, Damage> getAttackMap() {
        return createAttackMap();
    }

    /**
     * @return Map <String, Damage>
     * created map of regular attack
     */
    private static Map<String, Damage> createAttackMap() {
        Map<String, Damage> attackMap = new HashMap<>();

        attackMap.put("Attack with a sword", DamageOption.COUNT_2_DICE_10.getDamage());

        return attackMap;
    }

    /**
     * @return Map <String, AbstractAbility>,
     * created map of skills
     */
    private static Map<String, AbstractAbility> createSkillsMap() {
        Map<String, AbstractAbility> skillsMap = new HashMap<>();

        skillsMap.put(HumanAbility.SPLASH.getName(), new Splash());
        skillsMap.put(HumanAbility.RUSH.getName(), new Rush());

        return skillsMap;
    }
}
