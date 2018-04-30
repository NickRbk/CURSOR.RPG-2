package cursor.rybak.model.maze;

import cursor.rybak.model.room.Room;
import cursor.rybak.model.room.RoomDescription;
import cursor.rybak.model.room.RoomTypes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class MazeHelper {
    private Random random = new Random();

    int getRoomTypeIndex() {
        while (true) {
            int roomTypeIndex = getRandom(MazeConst.ROOM_TYPES_COUNT);

            int length = (int) Arrays.stream(MazeConst.ROOM_TYPES_ON_LINE)
                    .filter(el -> el.equals(RoomTypes.values()[roomTypeIndex].name()))
                    .count();

            if (length > 0) return roomTypeIndex;
        }
    }


    int getIndexForRoom(List<Room> chainedTo) {
        return chainedTo.indexOf(null);
    }


    void setConnections(Room firstRoom, Room secondRoom) {
        List<Room> chainedToR1 = firstRoom.getChainedTo();
        List<Room> chainedToR2 = secondRoom.getChainedTo();

        chainedToR1.set(getIndexForRoom(chainedToR1), secondRoom);
        chainedToR2.set(getIndexForRoom(chainedToR2), firstRoom);
    }


    /**
     * get random integer in range [1:maxValue)
     *
     * @param maxValue maxValue (exclusive)
     * @return random integer [1:maxValue)
     */
    private int getRandom(int maxValue) {
        return random.nextInt(maxValue - 1) + 1;
    }


    RoomDescription getRoomDescription() {
        int index = getRandom(MazeConst.ROOM_DESCRIPTION_COUNT);

        return RoomDescription.valueOf("LOCATION" + index);
    }
}
