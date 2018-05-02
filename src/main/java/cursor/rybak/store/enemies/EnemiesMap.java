package cursor.rybak.store.enemies;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MinLevel;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.store.enemies.components.CreatureMap;
import cursor.rybak.store.enemies.components.OrkoidMap;
import cursor.rybak.store.enemies.components.UndeadMap;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class EnemiesMap {
    private static EnemiesMap instance;

    private CreatureMap creatureMap;
    private OrkoidMap orkoidMap;
    private UndeadMap undeadMap;

    @Getter
    private Map<String, Map<MinLevel, Supplier<AbstractMonster>>> monstersMap;

    private EnemiesMap() {
        this.creatureMap = new CreatureMap();
        this.orkoidMap = new OrkoidMap();
        this.undeadMap = new UndeadMap();

        this.monstersMap = generateRaceMap();
    }

    public static EnemiesMap getInstance() {
        if (instance == null) {
            instance = new EnemiesMap();
        }

        return instance;
    }

    private Map<String, Map<MinLevel, Supplier<AbstractMonster>>> generateRaceMap() {
        Map<String, Map<MinLevel, Supplier<AbstractMonster>>> races = new LinkedHashMap<>();

        races.put(MonsterKinds.CREATURE.getKind(), this.creatureMap.getCreatureMonsters());
        races.put(MonsterKinds.ORKOID.getKind(), this.orkoidMap.getOrkoidMonsters());
        races.put(MonsterKinds.UNDEAD.getKind(), this.undeadMap.getUndeadMonsters());

        return races;
    }
}
