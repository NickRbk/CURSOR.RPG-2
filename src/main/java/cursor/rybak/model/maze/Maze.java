package cursor.rybak.model.maze;

import cursor.rybak.model.room.Room;
import cursor.rybak.model.room.RoomDescription;
import cursor.rybak.model.room.RoomSwitch;
import cursor.rybak.model.room.RoomTypes;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Getter
public class Maze implements MazeConst {
    private Room startRoom;
    private RoomSwitch roomsSwitch;
    private List<Room> rooms;
    private List<Room> impasseRooms;
    private MazeHelper helper;

    public Maze() {
        this.roomsSwitch = new RoomSwitch();
        this.rooms = new LinkedList<>();
        this.impasseRooms = new LinkedList<>();
        this.helper = new MazeHelper();

        generate();
    }

    private void generate() {
        while (getRooms().size() < MIN_ROOMS) {
            generateMazePath(initStartPoint(), INITIAL_DEEP);
            setImpasse();
        }
        putObjective();
    }

    /**
     * generate maze path on each level, invoke recursively
     *
     * @param firstRoom first start point
     * @param deep      the maze level
     */
    private void generateMazePath(Room firstRoom, int deep) {
        for (int i = 1; i < LINE_LEVEL_LENGTH[deep - 1]; i++) {

            Room secondRoom = this.roomsSwitch.getRoomsSwitch()
                    .get(RoomTypes.values()[this.helper.getRoomTypeIndex()])
                    .apply(this.helper.getRoomDescription());

            getRooms().add(secondRoom);
            this.helper.setConnections(firstRoom, secondRoom);
            generateSidePath(deep, firstRoom); // recursively invoke generateMazePath()
            firstRoom = secondRoom;
        }
    }

    //==============================================================================================
    private void generateSidePath(int currentDeep, Room room) {
        if (isMazeRecursion(currentDeep, room)) {
            generateMazePath(room, currentDeep + 1);
        }
    }

    private boolean isMazeRecursion(int currentDeep, Room room) {
        return currentDeep != DEEP
                && (isTypeEquals(room, RoomTypes.CROSS) || isTypeEquals(room, RoomTypes.START));
    }

    private boolean isTypeEquals(Room room, RoomTypes type) {
        return room.getType().equals(type);
    }
    //==============================================================================================


    /**
     * after maze path generated, set impasse rooms
     */
    private void setImpasse() {
        getRooms().forEach(room -> {
            while (this.helper.getIndexForRoom(room.getChainedTo()) != -1) {
                Room impasseRoom = this.roomsSwitch.getRoomsSwitch()
                        .get(RoomTypes.IMPASSE)
                        .apply(this.helper.getRoomDescription());

                getImpasseRooms().add(impasseRoom);
                this.helper.setConnections(room, impasseRoom);
            }
        });
    }

    private Room initStartPoint() {
        Room startRoom = this.roomsSwitch.getRoomsSwitch()
                .get(RoomTypes.START)
                .apply(RoomDescription.START_POINT);

        startRoom.setChecked(true);
        getRooms().add(startRoom);
        this.startRoom = startRoom;

        return startRoom;
    }

    private void putObjective() {
        int index = new Random().nextInt(rooms.size() - 30) + 25;
        Room room = getRooms().get(index);

        room.setObjective(true);
        room.setDescription(RoomDescription.END_POINT.getDescription());
        room.setLabel(RoomDescription.END_POINT.getLabel());
    }

    @Override
    public String toString() {
        return String.format("Maze generated, total rooms = %d",
                rooms.size() + impasseRooms.size());
    }
}
