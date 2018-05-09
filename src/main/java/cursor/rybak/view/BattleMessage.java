package cursor.rybak.view;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.team.Team;

import java.util.List;
import java.util.stream.Collectors;

public class BattleMessage implements MagicColors {
    private BattleMessage() {
    }

    public static void printStartBattleInfo() {
        System.out.print(RED + "\t<===BATTLE PHASE===>\n" + RESET);
    }

    public static void printUpgradeHero(AbstractRace hero) {
        System.out.format("\n\t%sHero %s upgraded to level %d%s\n",
                GREEN, hero.getHeroName(), hero.getLevel() + 1, RESET);
    }

    public static void printEnemies(List<AbstractMonster> enemies) {
        StringBuilder enemiesString = new StringBuilder();

        enemies.forEach(enemy -> enemiesString.append(String.format("%s(%d HP, %.2f XP)  ",
                enemy.getName(), enemy.getHealth(), enemy.getXp())));

        System.out.println("\t\t" + enemiesString);
    }

    public static void printOfferToBack(int count) {
        System.out.format("\t\tIn this room %d monsters: ... Maybe it's better to step back\n" +
                        "\t\t%sBack to previous room?%s - %sy%s or [%sany key to battle%s] -> ",
                count, BLUE, RESET, GREEN, RESET, GREEN, RESET);
    }

    public static void printTeamMembers(Team team) {
        System.out.println("\t\t" + team.printTeamMembers() + "\n");
    }

    public static void printGainedXP(AbstractRace hero, double totalXp) {
        System.out.format("\t\t\tHero %s gained %.2f XP\n",
                hero.getHeroName(), totalXp * hero.getXpCoefficient());
    }

    public static void informAboutTeamLine() {
        System.out.format("\t\tNow you should set your team members into battle line\n" +
                "\t\tMonsters attack first hero in line, if he died they attack next one\n");
    }

    public static void askHeroInTeamLine(List<AbstractRace> teamMembers) {
        System.out.format("\t\tWhat hero will be close to battle?\n\t\t\t");
        printTeamOptions(teamMembers);
    }

    private static void printTeamOptions(List<AbstractRace> teamMembers) {
        String[] heroes = new String[teamMembers.size()];

        for (int i = 0; i < heroes.length; i++) {
            AbstractRace hero = teamMembers.get(i);

            heroes[i] = String.format("%s%d%s-%s (%.2f HP, %.2f MP, %.2f RP)", GREEN, i + 1, RESET,
                    hero.getHeroName(), hero.getHealth(), hero.getMana(), hero.getRage());
        }
        Message.printOptions(heroes, Delimiter.NEW_LINE);
    }

    public static void printTeamLine(List<AbstractRace> teamLine) {
        String line = teamLine.stream()
                .map(AbstractRace::getHeroName)
                .collect(Collectors.joining(GREEN + Delimiter.ARROW + RESET));


        System.out.println("\n\t\t" + RED + "MONSTERS <== " + RESET + line);
    }
}
