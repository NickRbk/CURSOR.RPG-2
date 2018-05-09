package cursor.rybak.game;

import cursor.rybak.model.common.CommonUnit;
import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.room.Room;
import cursor.rybak.model.team.Team;
import cursor.rybak.util.ListUtil;
import cursor.rybak.view.BattleMessage;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Battle {
    private static final int COUNT = 3;

    public static boolean blitzkrieg(Room currentRoom) {
        BattleMessage.printStartBattleInfo();

        List<AbstractMonster> enemies = currentRoom.getEnemies();
        Team team = currentRoom.getTeam();

        if (isLeaderCool(team, enemies)) {
            printEnemiesAndTeam(enemies, team);
            if (enemies.size() > COUNT) {
                BattleMessage.printOfferToBack(enemies.size()); // offer Team to move back
                if (UserInteraction.askYesNo()) return false;
            }
        }

        battle(enemies, team); // dull active battle phase
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
    private static void battle(List<AbstractMonster> enemies, Team team) {

        List<CommonUnit> generalFightLine = generateSortedFightLine(enemies, team.getHeroes());
        List<AbstractRace> teamLine = BattleCtrl.createTeamLine(ListUtil.copy(team.getHeroes()));

//        fight(generalFightLine, teamLine, enemies);

//        generalFightLine.forEach(unit -> System.out.format("I - %d, Lvl - %d, XP - %.2f\n",
//                unit.getInitiative(), unit.getLevel(), unit.getXp()));


        double totalXp = enemies.stream()
                .map(AbstractMonster::getXp)
                .reduce((xp1, xp2) -> xp1 + xp2)
                .orElse(0.0);

        team.getHeroes()
                .forEach(hero -> {
                    BattleMessage.printGainedXP(hero, totalXp);
                    hero.gainXp(totalXp * hero.getXpCoefficient());
                });

        System.out.println("\n");
        team.tryLevelUp(); // try to Lvl up
    }

//    private static void fight(List<CommonUnit> generalFightLine,
//                              List<AbstractRace> teamLine,
//                              List<AbstractMonster> enemies) {
//
//        while (generalFightLine.size() > 1) {
//            generalFightLine.forEach(unit -> {
//
//                if (unit instanceof AbstractRace) {
//                    int enemyHP = enemies.get(0).getHealth();
//                    enemies.get(0).setHealth(enemyHP - ((AbstractRace) unit).attack());
//                }
//
//                if (unit instanceof AbstractMonster) {
//                    double heroHP = teamLine.get(0).getHealth();
//                    teamLine.get(0).setHealth(heroHP - ((AbstractMonster) unit).attack());
//                }
//
//            });
//        }
//    }

    private static List<CommonUnit> generateSortedFightLine(List<AbstractMonster> enemies, List<AbstractRace> heroes) {
        List<CommonUnit> fightLine = new LinkedList<>();

        fightLine.addAll(enemies);
        fightLine.addAll(heroes);

        fightLine.sort(new FightLineComparator());

        return fightLine;
    }

//    private static boolean isHeroAlive(Team team) {
//        return team.getHeroes().get(0).getHealth() > 0;
//    }
}
