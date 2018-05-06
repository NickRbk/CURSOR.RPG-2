package cursor.rybak.model.enemy;

import cursor.rybak.model.common.CommonUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class AbstractMonster implements CommonUnit {
    private static final int MIN_HEALTH = 0;

    @Setter
    private boolean spellImmune;

    private String kind; // kind of monster (e.g. UNDEAD, ORKOID, CREATURE)
    private String name; // name of monster in certain kind
    private int health;
    private int initiative;
    private double xp;
    private int level; // min Lvl from which monster sets in maze

    public AbstractMonster(String kind, String name, int health, int initiative, double xp, int level) {
        this.kind = kind;
        this.name = name;
        this.health = health;
        this.initiative = initiative;
        this.xp = xp;
        this.level = level;
    }

    /**
     * health should not be less 0
     *
     * @param health new health
     */
    public void setHealth(int health) {
        this.health = health < MIN_HEALTH ? MIN_HEALTH : health;
    }

    public abstract int attack();
}
