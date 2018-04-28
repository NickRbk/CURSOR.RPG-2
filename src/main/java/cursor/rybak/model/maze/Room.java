package cursor.rybak.model.maze;

import cursor.rybak.model.team.Team;
import cursor.rybak.util.RandomInt;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room implements RandomInt {
    private RoomTypes type;           // room type from 'RoomTypes' enum

    private String label;
    private String description;

    private Room previous;            // previous room
    private boolean isMonsterPresent; // marker for monsters env
    private Team team;

    private Room[] chainedTo;

    private boolean isObjective = false;
    private boolean isChecked = false; // when Team enter to room at first time the value set 'true'

    Room(String description, String label, RoomTypes type) {
        this.description = description;
        this.label = String.format("%s |%d|", label, getRandom(150));
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("\n\t%s\n%s", label, description);
    }

    public void setMonsterPresent(int value) {
        isMonsterPresent = value != 0;
    }
}
