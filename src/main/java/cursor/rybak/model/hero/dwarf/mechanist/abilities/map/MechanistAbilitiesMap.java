package cursor.rybak.model.hero.dwarf.mechanist.abilities.map;

import cursor.rybak.model.common.Damage;
import cursor.rybak.model.common.DamageOption;
import cursor.rybak.model.hero.AbilityType;
import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.dwarf.DwarfAbility;
import cursor.rybak.model.hero.dwarf.mechanist.abilities.Bombs;
import cursor.rybak.model.hero.dwarf.mechanist.abilities.DroidArms;
import cursor.rybak.model.race.kind.impl.Dwarf;

import java.util.HashMap;
import java.util.Map;

public class MechanistAbilitiesMap {

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
     * @return Map <String, int[]>
     * created map of regular attack
     */
    private static Map<String, Damage> createAttackMap() {
        Map<String, Damage> attackMap = new HashMap<>();

        attackMap.put("Attack with a gun", DamageOption.COUNT_2_DICE_6.getDamage());

        return attackMap;
    }

    /**
     * @return Map <String, AbstractAbility>,
     * created map of skills
     */
    private static Map<String, AbstractAbility> createSkillsMap() {
        Map<String, AbstractAbility> skillsMap = new HashMap<>();

        skillsMap.put(DwarfAbility.BOMBS.getName(), new Bombs());
        skillsMap.put(DwarfAbility.DROID_ARMS.getName(), new DroidArms());

        return skillsMap;
    }
}
