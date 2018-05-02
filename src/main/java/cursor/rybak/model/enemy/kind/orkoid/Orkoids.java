package cursor.rybak.model.enemy.kind.orkoid;

import cursor.rybak.model.enemy.MinLevel;
import lombok.Getter;

@Getter
public enum Orkoids implements MinLevel {
    Ogre("Ogre", 300, 5, 100, 9),                          // L9-10
    OrkWarlord("Ork Warlord", 150, 50, 40, 7),             // L7-8
    OrkShaman("Ork Shaman", 80, 35, 22, 5),                // L5-6
    Ork("Ork", 100, 30, 18, 3),                            // L3
    Goblin("Goblin", 35, 20, 10, 1),                       // L1-2
    UnstableAlchemist("Unstable Alchemist", 15, 25, 5, 1); // L1-2

    private String name;
    private int health;
    private int initiative;
    private int cost;
    private int minLevel;

    Orkoids(String name, int health, int initiative, int cost, int minLevel) {
        this.name = name;
        this.health = health;
        this.initiative = initiative;
        this.cost = cost;
        this.minLevel = minLevel;
    }
}