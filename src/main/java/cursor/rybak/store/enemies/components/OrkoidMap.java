package cursor.rybak.store.enemies.components;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MinLevel;
import cursor.rybak.model.enemy.kind.orkoid.Orkoids;
import cursor.rybak.model.enemy.kind.orkoid.impl.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class OrkoidMap {
    public Map<MinLevel, Supplier<AbstractMonster>> getOrkoidMonsters() {
        Map<MinLevel, Supplier<AbstractMonster>> monstersMap = new LinkedHashMap<>();

        monstersMap.put(Orkoids.GOBLIN, this::createGoblin);
        monstersMap.put(Orkoids.OGRE, this::createOgre);
        monstersMap.put(Orkoids.ORK, this::createOrk);
        monstersMap.put(Orkoids.ORK_SHAMAN, this::createOrkShaman);
        monstersMap.put(Orkoids.ORK_WARLORD, this::createOrkWarlord);
        monstersMap.put(Orkoids.UNSTABLE_ALCHEMIST, this::createUnstableAlchemist);

        return monstersMap;
    }

    private AbstractMonster createGoblin() {
        return new Goblin();
    }

    private AbstractMonster createOgre() {
        return new Ogre();
    }

    private AbstractMonster createOrk() {
        return new Ork();
    }

    private AbstractMonster createOrkShaman() {
        return new OrkShaman();
    }

    private AbstractMonster createOrkWarlord() {
        return new OrkWarlord();
    }

    private AbstractMonster createUnstableAlchemist() {
        return new UnstableAlchemist();
    }
}
