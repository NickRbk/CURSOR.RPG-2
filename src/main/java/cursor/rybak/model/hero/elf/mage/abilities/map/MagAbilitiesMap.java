package cursor.rybak.model.hero.elf.mage.abilities.map;

import cursor.rybak.model.common.Damage;
import cursor.rybak.model.common.DamageOption;
import cursor.rybak.model.hero.AbilityType;
import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.elf.ElfAbility;
import cursor.rybak.model.hero.elf.mage.abilities.*;

import java.util.HashMap;
import java.util.Map;

public class MagAbilitiesMap {

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

        attackMap.put("Wizard Stuff", DamageOption.COUNT_1_DICE_6.getDamage());
        attackMap.put("Imposition of an improvement", DamageOption.COUNT_1_DICE_6.getDamage());

        return attackMap;
    }

    /**
     * @return Map <String, AbstractAbility>,
     * created map of spells
     */
    private static Map<String, AbstractAbility> createSpellsMap() {
        Map<String, AbstractAbility> spellsMap = new HashMap<>();

        spellsMap.put(ElfAbility.FIREBALL.getName(), new Fireball());
        spellsMap.put(ElfAbility.SPELL_SHIELD.getName(), new SpellShield());
        spellsMap.put(ElfAbility.FROST_BOLT.getName(), new FrostBolt());
        spellsMap.put(ElfAbility.DISPEL.getName(), new Dispel());
        spellsMap.put(ElfAbility.STONE_GAZE.getName(), new StoneGaze());

        return spellsMap;
    }
}
