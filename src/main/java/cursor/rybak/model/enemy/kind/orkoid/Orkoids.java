package cursor.rybak.model.enemy.kind.orkoid;

import cursor.rybak.model.enemy.MinLevel;
import lombok.Getter;

@Getter
public enum Orkoids implements MinLevel {
    OGRE("Ogre", 300, 5, 100, 9),                          // L9-10
    ORK_WARLORD("Ork Warlord", 150, 50, 40, 7),             // L7-8
    ORK_SHAMAN("Ork Shaman", 80, 35, 22, 5),                // L5-6
    ORK("Ork", 100, 30, 18, 3),                            // L3
    UNSTABLE_ALCHEMIST("Unstable Alchemist", 15, 25, 5, 1), // L1-2
    GOBLIN("Goblin", 35, 20, 10, 1);                       // L1-2

    private String name;
    private int health;
    private int initiative;
    private double xp;
    private int level;

    Orkoids(String name, int health, int initiative, double xp, int level) {
        this.name = name;
        this.health = health;
        this.initiative = initiative;
        this.xp = xp;
        this.level = level;
    }
}