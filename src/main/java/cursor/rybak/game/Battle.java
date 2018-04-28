package cursor.rybak.game;

import cursor.rybak.model.room.Room;
import cursor.rybak.view.BattleMessage;

public class Battle {
    public static void blitzkrieg(Room currentRoom) {
        if(currentRoom.isMonsterPresent()) {
            BattleMessage.printStartBattleInfo();
            currentRoom.setMonsterPresent(0);
        }
    }
}
