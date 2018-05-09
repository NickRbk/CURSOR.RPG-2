package cursor.rybak.store.enemies.components;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MinLevel;
import cursor.rybak.model.enemy.kind.creature.Creatures;
import cursor.rybak.model.enemy.kind.creature.impl.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CreatureMap {
    public Map<MinLevel, Supplier<AbstractMonster>> getCreatureMonsters() {
        Map<MinLevel, Supplier<AbstractMonster>> monstersMap = new LinkedHashMap<>();

        monstersMap.put(Creatures.BLACK_DRAGON, this::createBlackDragon);
        monstersMap.put(Creatures.DOOMGUARD, this::createDoomguard);
        monstersMap.put(Creatures.DOOM_SPIDER, this::createDoomSpider);
        monstersMap.put(Creatures.IMP, this::createImp);
        monstersMap.put(Creatures.MINOTAUR, this::createMinotaur);
        monstersMap.put(Creatures.SUCCUBUS, this::createSuccubus);

        return monstersMap;
    }

    private AbstractMonster createBlackDragon() {
        return new BlackDragon();
    }

    private AbstractMonster createDoomguard() {
        return new Doomguard();
    }

    private AbstractMonster createDoomSpider() {
        return new DoomSpider();
    }

    private AbstractMonster createImp() {
        return new Imp();
    }

    private AbstractMonster createMinotaur() {
        return new Minotaur();
    }

    private AbstractMonster createSuccubus() {
        return new Succubus();
    }
}
