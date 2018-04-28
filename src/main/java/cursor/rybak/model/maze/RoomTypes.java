package cursor.rybak.model.maze;

import lombok.Getter;

@Getter
public enum RoomTypes {
    START(3), CROSS(4), STRAIGHT(2), IMPASSE(1);

    private int chainedRoom;

    RoomTypes(int chainedRoom) {
        this.chainedRoom = chainedRoom;
    }
}
