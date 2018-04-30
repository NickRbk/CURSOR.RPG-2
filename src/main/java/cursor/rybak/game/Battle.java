package cursor.rybak.game;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.room.Room;
import cursor.rybak.model.team.Team;
import cursor.rybak.view.BattleMessage;

import java.util.List;

public class Battle {
    public static void blitzkrieg(Room currentRoom) {
        if (currentRoom.isMonsterPresent()) {

            BattleMessage.printStartBattleInfo();
            BattleMessage.printEnemies(currentRoom.getEnemies());
            BattleMessage.printTeamMembers(currentRoom.getTeam());

            battle(currentRoom.getEnemies(), currentRoom.getTeam());

            currentRoom.setMonsterPresent(0);
        }
    }

    private static void battle(List<AbstractMonster> enemies, Team team) {
        int totalXp = enemies.stream()
                .map(AbstractMonster::getCost)
                .reduce((xp1, xp2) -> xp1 + xp2)
                .orElse(0);

        team.getHeroes()
                .forEach(hero -> {
                    BattleMessage.printGainedXP(hero, totalXp);
                    hero.gainXp(totalXp * hero.getXPCoefficient());
                });

        System.out.println("\n");
        team.tryLevelUp(); // try to Lvl up
    }
}
