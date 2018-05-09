package cursor.rybak.model.common;

import cursor.rybak.util.RandomInt;

public class Damage {
    private int count;
    private int dice;

    Damage(int count, int dice) {
        this.count = count;
        this.dice = dice;
    }

    public int getDamage() {
        int damage = 0;

        for (int i = 0; i < this.count; i++) {
            damage += RandomInt.getRandom(this.dice);
        }

        return damage;
    }
}
