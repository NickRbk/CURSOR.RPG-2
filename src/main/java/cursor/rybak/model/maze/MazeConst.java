package cursor.rybak.model.maze;

import cursor.rybak.model.room.RoomDescription;
import cursor.rybak.model.room.RoomTypes;

public interface MazeConst {
    int MIN_ROOMS = 50;

    int DEEP = 3;
    int INITIAL_DEEP = 1;

    // Levels connected with deep
    int LINE_LENGTH_LEVEL_1 = 7;
    int LINE_LENGTH_LEVEL_2 = 5;
    int LINE_LENGTH_LEVEL_3 = 6;

    int[] LINE_LEVEL_LENGTH = {LINE_LENGTH_LEVEL_1, LINE_LENGTH_LEVEL_2, LINE_LENGTH_LEVEL_3};

    int ROOM_TYPES_COUNT = RoomTypes.values().length;

    String[] ROOM_TYPES_ON_LINE = {RoomTypes.CROSS.name(), RoomTypes.STRAIGHT.name()};

    // subtract 2 because we **exclude** <START> and <END> descriptions
    // (they have special meaning)
    int ROOM_DESCRIPTION_COUNT = RoomDescription.values().length - 2;
}
