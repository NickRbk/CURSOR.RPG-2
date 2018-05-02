package cursor.rybak.store.enemies.count;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

public class EnemiesCountMap {
    private static EnemiesCountMap instance;

    @Getter
    private Map<Integer, Integer> monstersCountMap;

    private EnemiesCountMap() {
        this.monstersCountMap = generateMonstersCountMap();
    }

    public static EnemiesCountMap getInstance() {
        if (instance == null) {
            instance = new EnemiesCountMap();
        }

        return instance;
    }

    private static Map<Integer, Integer> generateMonstersCountMap() {
        Map<Integer, Integer> monstersCountMap = new LinkedHashMap<>();

        monstersCountMap.put(EnemiesCount.LVL_9.getMinLevel(), EnemiesCount.LVL_9.getTotalCount());
        monstersCountMap.put(EnemiesCount.LVL_7.getMinLevel(), EnemiesCount.LVL_7.getTotalCount());
        monstersCountMap.put(EnemiesCount.LVL_5.getMinLevel(), EnemiesCount.LVL_5.getTotalCount());
        monstersCountMap.put(EnemiesCount.LVL_3.getMinLevel(), EnemiesCount.LVL_3.getTotalCount());
        monstersCountMap.put(EnemiesCount.LVL_1.getMinLevel(), EnemiesCount.LVL_1.getTotalCount());

        return monstersCountMap;
    }
}
