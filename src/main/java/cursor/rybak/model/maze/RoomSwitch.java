package cursor.rybak.model.maze;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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

        room.setChainedTo(new Room[roomType.getChainedRoom()]);

        // set monsters in rooms (besides START)
        if (!roomType.equals(RoomTypes.START)) {
            room.setMonsterPresent(random.nextInt(1));
        }

        return room;
    }
}
