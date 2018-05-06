package cursor.rybak.model.enemy.kind.creature;

import cursor.rybak.model.enemy.MinLevel;
import lombok.Getter;

@Getter
public enum Creatures implements MinLevel {
    BlackDragon("Black Dragon", 400, 50, 500, 9),   // L9-10
    Minotaur("Minotaur", 150, 40, 40, 7),           // L7-8
    Succubus("Succubus", 100, 35, 35, 4),           // L4-6
    Doomguard("Doomguard", 60, 15, 15, 3),          // L3
    Imp("Imp", 30, 15, 10, 1),                      // L1-2
    DoomSpider("Doom Spider", 10, 5, 3, 1);         // L1-2

    private String name;
    private int health;
    private int initiative;
    private double xp;
    private int level;

    Creatures(String name, int health, int initiative, double xp, int level) {
        this.name = name;
        this.health = health;
        this.initiative = initiative;
        this.xp = xp;
        this.level = level;
    }
}
