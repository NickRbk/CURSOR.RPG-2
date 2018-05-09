package cursor.rybak.model.common;

import lombok.Getter;

public enum DamageOption {
    COUNT_1_DICE_6(1,6),
    COUNT_1_DICE_10(1,10),
    COUNT_1_DICE_100(1,100),
    COUNT_2_DICE_6(2,6),
    COUNT_2_DICE_10(2,10),
    COUNT_3_DICE_10(3,10);

    @Getter
    private Damage damage;

    DamageOption(int count, int dice) {
        this.damage = new Damage(count, dice);
    }
}
