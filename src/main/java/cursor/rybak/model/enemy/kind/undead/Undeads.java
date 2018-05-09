package cursor.rybak.model.enemy.kind.undead;

import cursor.rybak.model.enemy.MinLevel;
import lombok.Getter;

@Getter
public enum Undeads implements MinLevel {
    BONE_DRAGON("Bone Dragon", 550, 50, 300, 9),     // L9-10
    LICH("Lich", 100, 20, 25, 7),                   // L7-8
    BANSHEE("Banshee", 75, 15, 15, 5),              // L4-6
    ZOMBIE("Zombie", 80, 5, 15, 3),                 // L3
    SKELETON_CHIEF("Skeleton Chief", 60, 15, 10, 1), // L1-2
    SKELETON("Skeleton", 40, 10, 5, 1);             // L1-2

    private String name;
    private int health;
    private int initiative;
    private double xp;
    private int level;

    Undeads(String name, int health, int initiative, double xp, int level) {
        this.name = name;
        this.health = health;
        this.initiative = initiative;
        this.xp = xp;
        this.level = level;
    }
}
