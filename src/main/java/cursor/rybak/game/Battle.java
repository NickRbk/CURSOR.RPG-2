package cursor.rybak.game;

import cursor.rybak.model.room.Room;
import cursor.rybak.view.BattleMessage;

public class Battle {
    public static void blitzkrieg(Room currentRoom) {
        if(currentRoom.isMonsterPresent()) {
            BattleMessage.printStartBattleInfo();
            StringBuilder enemies = new StringBuilder();

            currentRoom.getEnemies()
                    .forEach(enemy -> enemies.append(String.format("%s(%d)  ", enemy.getName(), enemy.getHealth())));

            System.out.println(enemies.toString());

            currentRoom.setMonsterPresent(0);
        }
    }
}
