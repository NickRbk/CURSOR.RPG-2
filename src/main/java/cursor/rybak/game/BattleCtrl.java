package cursor.rybak.game;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.util.Scanner;
import cursor.rybak.util.Validation;
import cursor.rybak.view.BattleMessage;
import cursor.rybak.view.ErrorMessage;

import java.util.LinkedList;
import java.util.List;

public class BattleCtrl {
    private static Scanner scanner = Scanner.getInstance();
    private static Validation validator = Validation.getInstance();

    private BattleCtrl() {
    }

    public static List<AbstractRace> createTeamLine(List<AbstractRace> teamMembers) {
        List<AbstractRace> battleLine = new LinkedList<>();
        BattleMessage.informAboutTeamLine();

        generateBattleLine(battleLine, teamMembers);
        BattleMessage.printTeamLine(battleLine);

        return battleLine;
    }

    private static void generateBattleLine(List<AbstractRace> battleLine, List<AbstractRace> teamMembers) {
        while (teamMembers.size() > 1) {
            BattleMessage.askHeroInTeamLine(teamMembers);

            int option = getValidOption(teamMembers.size());
            battleLine.add(teamMembers.get(option));
            teamMembers.remove(option);
        }

        battleLine.add(teamMembers.get(0));
    }

    private static int getValidOption(int size) {
        while (true) {
            String userInput = scanner.getInput();

            if (validator.isNumberInput(userInput)) {
                int option = Integer.parseInt(userInput);
                if (validator.isNumberInRange(option, 0, size)) {
                    return option - 1;
                }
            }
            ErrorMessage.errorInfo();
        }
    }
}
