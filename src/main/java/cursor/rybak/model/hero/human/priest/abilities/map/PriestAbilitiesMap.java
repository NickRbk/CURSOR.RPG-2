package cursor.rybak.model.hero.human.priest.abilities.map;

import cursor.rybak.model.common.Damage;
import cursor.rybak.model.common.DamageOption;
import cursor.rybak.model.hero.AbilityType;
import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.human.HumanAbility;
import cursor.rybak.model.hero.human.priest.abilities.BattleFury;
import cursor.rybak.model.hero.human.priest.abilities.BattleTrance;
import cursor.rybak.model.hero.human.priest.abilities.HandGod;
import cursor.rybak.model.hero.human.priest.abilities.LayFists;

import java.util.HashMap;
import java.util.Map;

public class PriestAbilitiesMap {

    /**
     * @return created special attack map
     * with key appropriate key:
     * 'spells' or 'skills'
     */
    public static Map<String, Map<String, AbstractAbility>> getSpecialAttackMap() {
        Map<String, Map<String, AbstractAbility>> specialAttackMap = new HashMap<>();

        specialAttackMap.put(AbilityType.SPELLS, createSpellsMap());
        specialAttackMap.put(AbilityType.SKILLS, createSkillsMap());

        return specialAttackMap;
    }

    /**
     * @return Map <String, int[]>
     * created map of regular attack
     */
    public static Map<String, Damage> getAttackMap() {
        return createAttackMap();
    }

    /**
     * @return Map <String, int[]>
     * created map of regular attack
     */
    private static Map<String, Damage> createAttackMap() {
        Map<String, Damage> attackMap = new HashMap<>();

        attackMap.put("Attack with fists", DamageOption.COUNT_1_DICE_10.getDamage());

        return attackMap;
    }

    /**
     * @return Map <String, AbstractAbility>,
     * created map of spells
     */
    private static Map<String, AbstractAbility> createSpellsMap() {
        Map<String, AbstractAbility> spellsMap = new HashMap<>();

        spellsMap.put(HumanAbility.HAND_OF_GOD.getName(), new HandGod());
        spellsMap.put(HumanAbility.BATTLE_TRANCE.getName(), new BattleTrance());

        return spellsMap;
    }

    /**
     * @return Map <String, AbstractAbility>,
     * created map of skills
     */
    private static Map<String, AbstractAbility> createSkillsMap() {
        Map<String, AbstractAbility> skillsMap = new HashMap<>();

        skillsMap.put(HumanAbility.LAY_OF_FISTS.getName(), new LayFists());
        skillsMap.put(HumanAbility.BATTLE_FURY.getName(), new BattleFury());

        return skillsMap;
    }
}
