package cursor.rybak.model.room;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.packMap.EnemiesPackMap;

import java.util.*;
import java.util.function.Function;

public class RoomSwitch {
    private Random random = new Random();

    public Map<RoomTypes, Function<RoomDescription, Room>> getRoomsSwitch() {
        Map<RoomTypes, Function<RoomDescription, Room>> map = new HashMap<>();

        map.put(RoomTypes.START, this::createStartRoom);
        map.put(RoomTypes.IMPASSE, this::createImpasseRoom);
        map.put(RoomTypes.CROSS, this::createCrossRoom);
        map.put(RoomTypes.STRAIGHT, this::createStraightRoom);

        return map;
    }

    private Room createStartRoom(RoomDescription roomDescription) {
        return initRoom(roomDescription, RoomTypes.START);
    }


    private Room createImpasseRoom(RoomDescription roomDescription) {
        return initRoom(roomDescription, RoomTypes.IMPASSE);
    }


    private Room createCrossRoom(RoomDescription roomDescription) {
        return initRoom(roomDescription, RoomTypes.CROSS);
    }


    private Room createStraightRoom(RoomDescription roomDescription) {
        return initRoom(roomDescription, RoomTypes.STRAIGHT);
    }


    private Room initRoom(RoomDescription roomDescription, RoomTypes roomType) {
        Room room = new Room(roomDescription.getDescription(), roomDescription.getLabel(), roomType);

        room.setChainedTo(Arrays.asList(new Room[roomType.getChainedRoom()]));

        // set monsters in rooms (besides START)
        if (!roomType.equals(RoomTypes.START)) {
            room.setMonsterPresent(random.nextInt(2));
        }

        if (room.isMonsterPresent()) putEnemies(room);

        return room;
    }


    private void putEnemies(Room room) {
        int enemiesKind = random.nextInt(MonsterKinds.values().length);
        String kind = MonsterKinds.values()[enemiesKind].getKind();

        Map<String, List<AbstractMonster>> enemiesPack = EnemiesPackMap.getEnemiesPack().get(kind);

        String packIndex = "" + random.nextInt(enemiesPack.size());

        room.setEnemies(enemiesPack.get(packIndex));
    }
}
