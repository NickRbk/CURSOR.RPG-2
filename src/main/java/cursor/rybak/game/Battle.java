package cursor.rybak.game;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.room.Room;
import cursor.rybak.model.team.Team;
import cursor.rybak.view.BattleMessage;

import java.util.Arrays;
import java.util.List;

public class Battle {
    public static void blitzkrieg(Room currentRoom) {
        if (currentRoom.isMonsterPresent()) {
            BattleMessage.printStartBattleInfo();
            StringBuilder enemies = new StringBuilder();

            currentRoom.getEnemies()
                    .forEach(enemy -> enemies.append(String.format("%s(%d XP)  ", enemy.getName(), enemy.getCost())));

            System.out.println(enemies.toString());

            battle(currentRoom.getEnemies(), currentRoom.getTeam());

            currentRoom.setMonsterPresent(0);
        }
    }

    private static void battle(List<AbstractMonster> enemies, Team team) {
        int totalXp = enemies.stream()
                .map(AbstractMonster::getCost)
                .reduce((xp1, xp2) -> xp1 + xp2)
                .orElse(0);

        Arrays.stream(team.getHeroes())
                .forEach(hero -> hero.gainXp(totalXp * hero.getXPCoefficient()));
    }
}
