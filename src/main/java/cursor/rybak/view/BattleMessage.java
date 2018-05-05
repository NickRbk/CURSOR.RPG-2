package cursor.rybak.view;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.team.Team;

import java.util.List;

public class BattleMessage implements MagicColors {
    public static void printStartBattleInfo() {
        System.out.print(RED + "\t<===BATTLE PHASE WILL BE HERE===>\n" + RESET);
    }

    public static void printUpgradeHero(AbstractRace hero) {
        System.out.format("\n\t%sHero %s upgraded to level %d%s\n",
                GREEN, hero.getHeroName(), hero.getLevel() + 1, RESET);
    }

    public static void printEnemies(List<AbstractMonster> enemies) {
        StringBuilder enemiesString = new StringBuilder();

        enemies.forEach(enemy -> enemiesString.append(String.format("%s(%d HP, %d XP)  ",
                enemy.getName(), enemy.getHealth(), enemy.getCost())));

        System.out.println("\t\t" + enemiesString.toString());
    }

    public static void printOfferToBack(int count) {
        System.out.format("\t\tIn this room %d monsters: ... Maybe it's better to step back\n" +
                "\t\t%sBack to previous room?%s - %sy%s or [%sany key to battle%s] -> ",
                count, BLUE, RESET, GREEN, RESET, GREEN, RESET);
    }

    public static void printTeamMembers(Team team) {
        System.out.println("\t\t" + team.printTeamMembers() + "\n");
    }

    public static void printGainedXP(AbstractRace hero, int totalXp) {
        System.out.format("\t\t\tHero %s gained %.2f XP\n",
                hero.getHeroName(), totalXp * hero.getXPCoefficient());
    }
}
