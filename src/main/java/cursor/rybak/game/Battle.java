package cursor.rybak.game;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.room.Room;
import cursor.rybak.model.team.Team;
import cursor.rybak.view.BattleMessage;

import java.util.Comparator;
import java.util.List;

public class Battle {
    private static final int COUNT = 3;

    public static boolean blitzkrieg(Room currentRoom) {
        BattleMessage.printStartBattleInfo();

        List<AbstractMonster> enemies = currentRoom.getEnemies();
        Team team = currentRoom.getTeam();
        boolean isLeaderCool = isLeaderCool(team, enemies);

        if (isLeaderCool) {
            printEnemiesAndTeam(enemies, team);
            if (enemies.size() > COUNT) {
                BattleMessage.printOfferToBack(enemies.size()); // offer Team to move back
                if (UserInteraction.askYesNo()) return false;
            }
        }

        battle(enemies, team, isLeaderCool); // dull active battle phase
        currentRoom.setMonsterPresent(0);
        return true;
    }


    private static void printEnemiesAndTeam(List<AbstractMonster> enemies, Team team) {
        BattleMessage.printEnemies(enemies); // print enemies pack
        BattleMessage.printTeamMembers(team);
    }


    /**
     * check if Leader more initiative than enemies
     *
     * @param team    our Team
     * @param enemies Room's enemies
     * @return boolean
     */
    private static boolean isLeaderCool(Team team, List<AbstractMonster> enemies) {
        return team.getHeroes().get(0).getInitiative() > getEnemiesMaxInitiative(enemies);
    }


    /**
     * get enemies' max initiative
     *
     * @param enemies Room's enemies
     * @return max initiative
     */
    private static int getEnemiesMaxInitiative(List<AbstractMonster> enemies) {
        Comparator<AbstractMonster> comparator = Comparator.comparing(AbstractMonster::getInitiative);

        return enemies.stream()
                .max(comparator)
                .get()
                .getInitiative();
    }

    // Dull active battle phase, in future will be changed
    private static void battle(List<AbstractMonster> enemies, Team team, boolean isLeaderCool) {
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
