package cursor.rybak.model.room;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.team.Team;
import cursor.rybak.store.enemies.EnemiesMap;
import cursor.rybak.store.enemies.count.EnemiesCountMap;
import cursor.rybak.util.RandomInt;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Getter
@Setter
public class Room {
    private RoomTypes type;           // room type from 'RoomTypes' enum

    private String label;
    private String description;

    private Room previous;            // previous room
    private boolean isMonsterPresent; // marker for monsters env

    private List<AbstractMonster> enemies;
    private Team team;

    private List<Room> chainedTo;

    private boolean isObjective;

    Room(String description, String label, RoomTypes type) {
        this.description = description;
        this.label = String.format("%s |%d|", label, RandomInt.getRandom(150));
        this.type = type;
    }

    public static void setMonsters(double averageLevel, Room room) {
        Random random = new Random();

        int monstersCount = getMonstersCount(averageLevel);

        List<Supplier<AbstractMonster>> availableMonsters = getAvailableMonsters(averageLevel);

        room.setEnemies( new LinkedList<>());

        while(room.getEnemies().size() < monstersCount) {
            int monsterIndex = random.nextInt(availableMonsters.size());

            room.getEnemies().add( availableMonsters.get(monsterIndex).get() );
        }
    }

    private static int getMonstersCount(double averageLevel) {
        return EnemiesCountMap.getInstance()
                .getMonstersCountMap()
                .entrySet()
                .stream()
                .filter(map -> map.getKey() <= averageLevel)
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(0);
    }

    private static List<Supplier<AbstractMonster>> getAvailableMonsters(double averageLevel) {
        Random random = new Random();

        int enemiesKind = random.nextInt(MonsterKinds.values().length);
        String kind = MonsterKinds.values()[enemiesKind].getKind();

        return EnemiesMap.getInstance()
                .getMonstersMap()
                .get(kind)
                .entrySet()
                .stream()
                .filter(map -> map.getKey().getMinLevel() <= averageLevel)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("\n\t%s\n%s", label, description);
    }

    public void setMonsterPresent(int value) {
        isMonsterPresent = value != 0;
    }
}
