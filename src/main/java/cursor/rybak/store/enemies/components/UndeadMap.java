package cursor.rybak.store.enemies.components;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MinLevel;
import cursor.rybak.model.enemy.kind.undead.Undeads;
import cursor.rybak.model.enemy.kind.undead.impl.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class UndeadMap {
    public Map<MinLevel, Supplier<AbstractMonster>> getUndeadMonsters() {
        Map<MinLevel, Supplier<AbstractMonster>> monstersMap = new LinkedHashMap<>();

        monstersMap.put(Undeads.Banshee, this::createBanshee);
        monstersMap.put(Undeads.BoneDragon, this::createBoneDragon);
        monstersMap.put(Undeads.Lich, this::createLich);
        monstersMap.put(Undeads.Skeleton, this::createSkeleton);
        monstersMap.put(Undeads.SkeletonChief, this::createSkeletonChief);
        monstersMap.put(Undeads.Zombie, this::createZombie);

        return monstersMap;
    }

    private AbstractMonster createBanshee() {
        return new Banshee();
    }

    private AbstractMonster createBoneDragon() {
        return new BoneDragon();
    }

    private AbstractMonster createLich() {
        return new Lich();
    }

    private AbstractMonster createSkeleton() {
        return new Skeleton();
    }

    private AbstractMonster createSkeletonChief() {
        return new SkeletonChief();
    }

    private AbstractMonster createZombie() {
        return new Zombie();
    }
}
