package cursor.rybak.model.hero.human;

import cursor.rybak.model.common.Damage;
import cursor.rybak.model.common.DamageOption;
import lombok.Getter;

@Getter
public enum HumanAbility {
    BATTLE_FURY("Battle Fury", 30, 3, DamageOption.COUNT_1_DICE_10.getDamage()),
    BATTLE_TRANCE("Battle Trance", 65, 4, null),
    HAND_OF_GOD("Hand of God", 25, 2, null),
    LAY_OF_FISTS("Lay of Fists", 10, 3, DamageOption.COUNT_1_DICE_10.getDamage()),
    RUSH("Rush", 20, 0, DamageOption.COUNT_2_DICE_10.getDamage()),
    SPLASH("Splash", 20, 2, DamageOption.COUNT_2_DICE_10.getDamage());

    private String name;
    private int energyConsumption;
    private int coolDown;
    private Damage damage;

    HumanAbility(String name, int energyConsumption, int coolDown, Damage damage) {
        this.name = name;
        this.energyConsumption = energyConsumption;
        this.coolDown = coolDown;
        this.damage = damage;
    }
}
