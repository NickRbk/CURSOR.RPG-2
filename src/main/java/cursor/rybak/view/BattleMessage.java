package cursor.rybak.view;

import cursor.rybak.model.race.AbstractRace;

public class BattleMessage implements MagicColors {
    public static void printStartBattleInfo() {
        System.out.print(RED + "\t<===BATTLE PHASE WILL BE HERE===>" + RESET);
    }


    public static void printUpgradeHero(AbstractRace hero) {
        System.out.format("\n\t%sHero %s upgraded to level %d%s\n",
                GREEN, hero.getHeroName(), hero.getLevel() + 1, RESET);
    }
}
