package cursor.rybak.model.hero.dwarf;

import cursor.rybak.model.common.Damage;
import cursor.rybak.model.common.DamageOption;
import lombok.Getter;

@Getter
public enum DwarfAbility {

    WHIRLING_AXE("Whirling Axe", 30, 2, DamageOption.COUNT_2_DICE_10.getDamage()),
    STAND_GROUND("Stand ground", 20, 4, null),
    DROID_ARMS("Droid to arms", 25, 5, DamageOption.COUNT_2_DICE_6.getDamage()),
    BOMBS("Bombs!", 25, 2, DamageOption.COUNT_2_DICE_6.getDamage());

    private String name;
    private int energyConsumption;
    private int coolDown;
    private Damage damage;

    DwarfAbility(String name, int energyConsumption, int coolDown, Damage damage) {
        this.name = name;
        this.energyConsumption = energyConsumption;
        this.coolDown = coolDown;
        this.damage = damage;
    }
}
