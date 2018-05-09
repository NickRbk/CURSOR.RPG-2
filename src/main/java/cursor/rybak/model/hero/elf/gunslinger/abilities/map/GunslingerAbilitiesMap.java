package cursor.rybak.model.hero.elf.gunslinger.abilities.map;

import cursor.rybak.model.common.Damage;
import cursor.rybak.model.common.DamageOption;
import cursor.rybak.model.hero.AbilityType;
import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.elf.ElfAbility;
import cursor.rybak.model.hero.elf.gunslinger.abilities.BullsEye;
import cursor.rybak.model.hero.elf.gunslinger.abilities.Multishot;
import cursor.rybak.model.hero.elf.gunslinger.abilities.RapidFire;

import java.util.HashMap;
import java.util.Map;

public class GunslingerAbilitiesMap {

    /**
     * @return created special attack map
     * with key appropriate key:
     * 'spells' or 'skills'
     */
    public static Map<String, Map<String, AbstractAbility>> getSpecialAttackMap() {
        Map<String, Map<String, AbstractAbility>> specialAttackMap = new HashMap<>();

        specialAttackMap.put(AbilityType.SPELLS, createSpellsMap());

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

        attackMap.put("Shoot from the bow", DamageOption.COUNT_2_DICE_6.getDamage());
        attackMap.put("Attack with dagger", DamageOption.COUNT_1_DICE_6.getDamage());

        return attackMap;
    }

    /**
     * @return Map <String, AbstractAbility>,
     * created map of spells
     */
    private static Map<String, AbstractAbility> createSpellsMap() {
        Map<String, AbstractAbility> spellsMap = new HashMap<>();

        spellsMap.put(ElfAbility.MULTISHOT.getName(), new Multishot());
        spellsMap.put(ElfAbility.RAPID_FIRE.getName(), new RapidFire());
        spellsMap.put(ElfAbility.BULLS_EYE.getName(), new BullsEye());

        return spellsMap;
    }
}
