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

        monstersMap.put(Orkoids.Goblin, this::createGoblin);
        monstersMap.put(Orkoids.Ogre, this::createOgre);
        monstersMap.put(Orkoids.Ork, this::createOrk);
        monstersMap.put(Orkoids.OrkShaman, this::createOrkShaman);
        monstersMap.put(Orkoids.OrkWarlord, this::createOrkWarlord);
        monstersMap.put(Orkoids.UnstableAlchemist, this::createUnstableAlchemist);

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
