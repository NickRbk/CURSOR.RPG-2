package cursor.rybak.store.enemies.count;

import lombok.Getter;

@Getter
public enum EnemiesCount {
    LVL_1(1, 3), LVL_3(3, 4), LVL_5(5, 4), LVL_7(7, 5), LVL_9(9, 4);

    private int minLevel;
    private int totalCount;

    EnemiesCount(int minLevel, int totalCount) {
        this.minLevel = minLevel;
        this.totalCount = totalCount;
    }
}
