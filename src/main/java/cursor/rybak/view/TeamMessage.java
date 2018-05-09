package cursor.rybak.view;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.race.Characteristics;
import cursor.rybak.model.team.Team;

import java.util.List;

public class TeamMessage implements MagicColors {
    private TeamMessage() {
    }

    /**
     * print info about Team
     *
     * @param team instance of Team
     */
    public static void printTeamInfo(Team team) {
        String leftAlignFormat = "| %-20s | %-20s | %-20s | %-20s |%n";
        System.out.println(CYAN + "\n\tTeam: " + team.getName() + RESET);
        printTeamTableHeader(leftAlignFormat, team.getHeroes());
        printTeamMemberInfo(leftAlignFormat, team.getHeroes());
    }


    /**
     * print header for table about Team
     *
     * @param format special format String
     * @param hero   array of heroes
     */
    private static void printTeamTableHeader(String format, List<AbstractRace> hero) {
        printTeamTableDivider();
        System.out.format(format, "Characteristic\\Hero",
                hero.get(0).getHeroName() + " (L)", hero.get(1).getHeroName(), hero.get(2).getHeroName());
        printTeamTableDivider();
    }


    /**
     * divider in table about Team
     */
    private static void printTeamTableDivider() {
        System.out.format("+----------------------+----------------------+----------------------" +
                "+----------------------+%n");
    }


    /**
     * print info about Team members
     *
     * @param format special format String
     * @param hero   array of heroes
     */
    private static void printTeamMemberInfo(String format, List<AbstractRace> hero) {

        printHeroesVitalCharacteristic(format, hero);
        printTeamTableDivider();

        printHeroesCharacteristic(format, hero);
        printTeamTableDivider();
    }


    /**
     * print info about vital characteristics of Team's heroes (Part #1)
     * (such as Profession, Health, Mana, Rage)
     *
     * @param format special format String
     * @param hero   array of heroes
     */
    private static void printHeroesVitalCharacteristic(String format, List<AbstractRace> hero) {
        String doubleFormat = "| %-20s | %-20.2f | %-20.2f | %-20.2f |%n";

        System.out.format(format, "Profession",
                hero.get(0).getHeroKind() + "  (" + hero.get(0).getRace() + ")",
                hero.get(1).getHeroKind() + "  (" + hero.get(1).getRace() + ")",
                hero.get(2).getHeroKind() + "  (" + hero.get(2).getRace() + ")"
        );

        System.out.format(format, "Level",
                hero.get(0).getLevel(), hero.get(1).getLevel(), hero.get(2).getLevel());

        System.out.format(format, "Initiative",
                hero.get(0).getInitiative(), hero.get(1).getInitiative(), hero.get(2).getInitiative());

        System.out.format(doubleFormat, "XP",
                hero.get(0).getXp(), hero.get(1).getXp(), hero.get(2).getXp());

        printTeamTableDivider();

        System.out.format(doubleFormat, "Health",
                hero.get(0).getHealth(), hero.get(1).getHealth(), hero.get(2).getHealth());

        System.out.format(doubleFormat, "Mana",
                hero.get(0).getMana(), hero.get(1).getMana(), hero.get(2).getMana());

        System.out.format(doubleFormat, "Rage",
                hero.get(0).getRage(), hero.get(1).getRage(), hero.get(2).getRage());
    }


    /**
     * print info about characteristics of Team's heroes (Part #2)
     * (such as Charisma, Stamina, Intellect, Agility, Concentration)
     *
     * @param format special format String
     * @param hero   special format String
     */
    private static void printHeroesCharacteristic(String format, List<AbstractRace> hero) {
        System.out.format(format, Characteristics.CHARISMA,
                hero.get(0).getCharisma(), hero.get(1).getCharisma(), hero.get(2).getCharisma());

        System.out.format(format, Characteristics.STAMINA,
                hero.get(0).getStamina(), hero.get(1).getStamina(), hero.get(2).getStamina());

        System.out.format(format, Characteristics.INTELLECT,
                hero.get(0).getIntellect(), hero.get(1).getIntellect(), hero.get(2).getIntellect());

        System.out.format(format, Characteristics.AGILITY,
                hero.get(0).getAgility(), hero.get(1).getAgility(), hero.get(2).getAgility());

        System.out.format(format, Characteristics.CONCENTRATION,
                hero.get(0).getConcentration(), hero.get(1).getConcentration(), hero.get(2).getConcentration());
    }
}
