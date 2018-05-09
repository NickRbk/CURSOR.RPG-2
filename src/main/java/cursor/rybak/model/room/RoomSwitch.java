package cursor.rybak.model.room;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

public class RoomSwitch {
    private static RoomSwitch instance;
    private Random random;

    @Getter
    private Map<RoomTypes, Function<RoomDescription, Room>> roomsSwitch;

    private RoomSwitch() {
        this.random = new Random();
        this.roomsSwitch = generateRoomsSwitch();
    }

    public static RoomSwitch getInstance() {
        if (instance == null) {
            instance = new RoomSwitch();
        }

        return instance;
    }

    private Map<RoomTypes, Function<RoomDescription, Room>> generateRoomsSwitch() {
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
        if (roomType != RoomTypes.START) {
            room.setMonsterPresent(random.nextInt(2));
        }

        return room;
    }
}
