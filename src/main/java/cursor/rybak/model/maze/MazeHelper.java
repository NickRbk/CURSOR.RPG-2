package cursor.rybak.model.maze;

import java.util.Arrays;
import java.util.Random;

public interface MazeHelper {
    Random random = new Random();

    default int getRoomTypeIndex() {
        while (true) {
            int roomTypeIndex = getRandom(MazeConst.ROOM_TYPES_COUNT);

            int length = (int) Arrays.stream(MazeConst.ROOM_TYPES_ON_LINE)
                    .filter(el -> el.equals(RoomTypes.values()[roomTypeIndex].name()))
                    .count();

            if (length > 0) return roomTypeIndex;
        }
    }


    default int getIndexForRoom(Room[] chainedTo) {
        return Arrays.asList(chainedTo)
                .indexOf(null);
    }


    default void setConnections(Room firstRoom, Room secondRoom) {
        Room[] chainedToR1 = firstRoom.getChainedTo();
        Room[] chainedToR2 = secondRoom.getChainedTo();

        chainedToR1[getIndexForRoom(chainedToR1)] = secondRoom;
        chainedToR2[getIndexForRoom(chainedToR2)] = firstRoom;
    }


    /**
     * get random integer in range [1:maxValue)
     *
     * @param maxValue maxValue (exclusive)
     * @return random integer [1:maxValue)
     */
    default int getRandom(int maxValue) {
        return random.nextInt(maxValue - 1) + 1;
    }


    default RoomDescription getRoomDescription() {
        int index = getRandom(MazeConst.ROOM_DESCRIPTION_COUNT);

        return RoomDescription.valueOf("LOCATION" + index);
    }
}
