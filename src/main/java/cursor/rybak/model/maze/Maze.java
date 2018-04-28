package cursor.rybak.model.maze;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Maze implements MazeConst, MazeHelper {
    @Getter
    private Room startRoom;
    private RoomSwitch roomsSwitch = new RoomSwitch();

    private List<Room> rooms = new LinkedList<>();
    private List<Room> impasseRooms = new LinkedList<>();

    public Maze() {
        generate();
    }

    private void generate() {
        while (rooms.size() < MIN_ROOMS) {
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
            Room secondRoom = roomsSwitch.getRoomsSwitch()
                    .get(RoomTypes.values()[getRoomTypeIndex()])
                    .apply(getRoomDescription());

            rooms.add(secondRoom);
            setConnections(firstRoom, secondRoom);
            generateSidePath(deep, firstRoom); // recursively invoke generateMazePath()
            firstRoom = secondRoom;
        }
    }


    private void generateSidePath(int currentDeep, Room room) {
        if (currentDeep != DEEP
                && (room.getType().equals(RoomTypes.CROSS) || room.getType().equals(RoomTypes.START))) {

            generateMazePath(room, currentDeep + 1);
        }
    }

    /**
     * after maze path generated, set impasse rooms
     */
    private void setImpasse() {
        rooms.forEach(room -> {
            while (getIndexForRoom(room.getChainedTo()) != -1) {
                Room impasseRoom = roomsSwitch.getRoomsSwitch()
                        .get(RoomTypes.IMPASSE)
                        .apply(getRoomDescription());

                impasseRooms.add(impasseRoom);
                setConnections(room, impasseRoom);
            }
        });
    }

    private Room initStartPoint() {
        Room startRoom = roomsSwitch.getRoomsSwitch()
                .get(RoomTypes.START)
                .apply(RoomDescription.START_POINT);

        startRoom.setChecked(true);
        rooms.add(startRoom);
        this.startRoom = startRoom;

        return startRoom;
    }

    private void putObjective() {
        int index = new Random().nextInt(rooms.size() - 15) + 10;
        rooms.get(index).setObjective(true);
        rooms.get(index).setDescription(RoomDescription.END_POINT.getDescription());
        rooms.get(index).setLabel(RoomDescription.END_POINT.getLabel());
    }

    @Override
    public String toString() {
        return String.format("Maze generated, total rooms = %d",
                rooms.size() + impasseRooms.size());
    }
}
