package cursor.rybak.model.enemy.kind.undead;

import cursor.rybak.model.enemy.MinLevel;
import lombok.Getter;

@Getter
public enum Undeads implements MinLevel {
    BoneDragon("Bone Dragon", 550, 50, 300, 9),     // L9-10
    Lich("Lich", 100, 20, 25, 7),                   // L7-8
    Banshee("Banshee", 75, 15, 15, 5),              // L4-6
    Zombie("Zombie", 80, 5, 15, 3),                 // L3
    SkeletonChief("Skeleton Chief", 60, 15, 10, 1), // L1-2
    Skeleton("Skeleton", 40, 10, 5, 1);             // L1-2

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
