package cursor.rybak.model.hero.elf;

import cursor.rybak.model.common.Damage;
import cursor.rybak.model.common.DamageOption;
import lombok.Getter;

@Getter
public enum ElfAbility {
    STONE_GAZE("Stone Gaze", 20, 4, null),
    SPELL_SHIELD("Spell Shield", 15, 2, null),
    FROST_BOLT("Frost Bolt", 20, 1, DamageOption.COUNT_2_DICE_6.getDamage()),
    FIREBALL("Fireball", 45, 3, DamageOption.COUNT_3_DICE_10.getDamage()),
    DISPEL("Dispel", 20, 3, null),
    RAPID_FIRE("RapidFire", 30, 3, DamageOption.COUNT_2_DICE_6.getDamage()),
    MULTISHOT("Multishot", 30, 2, DamageOption.COUNT_2_DICE_6.getDamage()),
    BULLS_EYE("BullsEye", 40, 3, DamageOption.COUNT_3_DICE_10.getDamage());


    private String name;
    private int energyConsumption;
    private int coolDown;
    private Damage damage;

    ElfAbility(String name, int energyConsumption, int coolDown, Damage damage) {
        this.name = name;
        this.energyConsumption = energyConsumption;
        this.coolDown = coolDown;
        this.damage = damage;
    }
}
