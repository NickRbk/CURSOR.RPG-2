package cursor.rybak.game;

import cursor.rybak.model.race.AbstractRace;
import cursor.rybak.model.race.Characteristics;
import cursor.rybak.model.room.Room;
import cursor.rybak.store.heroes.HeroesMap;
import cursor.rybak.util.DistributionSwitch;
import cursor.rybak.util.Scanner;
import cursor.rybak.util.Validation;
import cursor.rybak.view.ErrorMessage;
import cursor.rybak.view.GeneralMessage;
import cursor.rybak.view.MazeMessage;
import cursor.rybak.view.Message;

import java.util.*;
import java.util.function.Supplier;

public class UserInteraction {
    private static Scanner scanner = Scanner.getInstance();
    private static Validation validator = Validation.getInstance();

    /**
     * ask about name (for props, that validate
     * only for empty field)
     *
     * @return name of some property
     */
    public static String askName(String item) {
        Message.askName(item);

        while (true) {
            String userInput = scanner.getInput().toUpperCase().trim();

            if (!userInput.isEmpty()) {
                return userInput;
            }
            ErrorMessage.errorEmptyInput();
        }
    }


    /**
     * choose some item from list by options
     * (validate input)
     *
     * @param items String[]
     * @return chosen option
     */
    private static int chooseOption(String[] items) {
        while (true) {
            String userInput = scanner.getInput();

            if (validator.isNumberInput(userInput)) {
                int option = Integer.parseInt(userInput);

                if (validator.isNumberInRange(option, 0, items.length)) {
                    return option - 1;
                }
            }

            ErrorMessage.errorInfo();
        }
    }


    /**
     * choose move option
     * (validate input)
     *
     * @return chosen move option
     */
    public static String chooseMoveOption(Room currentRoom) {
        String options = MazeMessage.getAndAskMoveOptions(currentRoom);

        while (true) {
            String userInput = scanner.getInput();

            if (validator.isMatchOptions(userInput, options)) {
                return userInput;
            }

            ErrorMessage.errorInfo();
        }
    }


    /**
     * ask about race for heroes
     *
     * @return name of race
     */
    private static String askRace() {
        Set<String> racesKey = HeroesMap.getInstance().getRaceMap().keySet();
        String[] races = racesKey.toArray(new String[racesKey.size()]);

        Message.askName("race");
        Message.printRaces();
        int option = chooseOption(races);

        Message.printChosenOption(races[option]);

        return races[option];
    }


    /**
     * ask about about hero
     *
     * @param heroesMap map of heroes for particular race
     * @param race      race
     * @return chosen hero
     */
    private static AbstractRace askHero(Map<String, Supplier<AbstractRace>> heroesMap, String race) {
        Set<String> heroesKey = heroesMap.keySet();
        String[] heroes = heroesKey.toArray(new String[heroesKey.size()]);

        Message.askName("hero");
        Message.printRaceHeroes(race);
        int option = chooseOption(heroes);

        Message.printChosenOption(heroes[option]);

        return heroesMap
                .get(heroes[option])
                .get();
    }


    /**
     * ask about team members (can be from different races)
     *
     * @param teamMembers heroes number in team
     * @return array of heroes
     */
    public static List<AbstractRace> askHeroes(int teamMembers) {
        List<AbstractRace> teamHeroes = new LinkedList<>();

        Message.askHeroLeader();

        while (teamHeroes.size() < teamMembers) {
            initializeHero(teamHeroes);

            int currentTeamSize = teamHeroes.size();

            if (currentTeamSize < teamMembers) {
                Message.askMoreHero(currentTeamSize, teamMembers);
            }
        }

        return teamHeroes;
    }


    /**
     * initialize hero with name of the particular race
     *
     * @param teamHeroes team
     */
    private static void initializeHero(List<AbstractRace> teamHeroes) {
        Map<String, Map<String, Supplier<AbstractRace>>> raceMap = HeroesMap.getInstance().getRaceMap();

        String name = askName("hero name");
        String race = askRace();
        AbstractRace hero = askHero(raceMap.get(race), race);
        hero.setHeroName(name);

        distributePoints(hero);

        teamHeroes.add(hero);
    }


    /**
     * distribute point to upgrade from total points
     *
     * @param hero instance of particular hero
     */
    public static void distributePoints(AbstractRace hero) {
        int remainedPoints = hero.getSp();
        Message.printDistributionIntro(remainedPoints);

        while (remainedPoints > 0) {
            String characteristic = askKeyToUpgrade(hero.keyToUpgrade);

            Message.printRemainedPoints(remainedPoints);

            remainedPoints = upgradeHeroKey(remainedPoints, characteristic, hero);
        }
    }


    /**
     * ask for particular hero's characteristic
     *
     * @param options array of options
     * @return chosen option
     */
    private static String askKeyToUpgrade(String[] options) {
        int option;

        do {
            Message.askName("characteristic to upgrade");
            Message.printKeyToUpgrade(options.clone());

            option = chooseOption(options);

            if (Characteristics.INFO.equals(options[option])) {
                GeneralMessage.characteristicsInfo();
            }
        } while (Characteristics.INFO.equals(options[option]));

        Message.printChosenOption(options[option]);
        return options[option];
    }


    /**
     * upgrade particular hero's characteristic
     *
     * @param remainedPoints total points
     * @param characteristic concrete key needs to upgrade
     * @param hero           instance of particular hero
     * @return remained points
     */
    private static int upgradeHeroKey(int remainedPoints, String characteristic, AbstractRace hero) {
        int newRemainedPoints = remainedPoints;

        while (newRemainedPoints == remainedPoints) {
            String userInput = scanner.getInput();

            if (validator.isNumberInput(userInput)
                    && validator.isNumberInRange(parseInt(userInput), 0, remainedPoints)) {

                updateSp(hero, parseInt(userInput));
                upgradeCharacteristic(characteristic, hero, parseInt(userInput));
                remainedPoints -= parseInt(userInput);
                Message.printUpgradeInfo(userInput, characteristic, hero.getHeroName());

                if (remainedPoints != 0) Message.printRemainedInfo(remainedPoints);
            } else {
                ErrorMessage.errorOutOfBound(remainedPoints);
            }
        }

        return remainedPoints;
    }


    /**
     * update hero skill points
     *
     * @param hero      current hero
     * @param userInput input value
     */
    private static void updateSp(AbstractRace hero, int userInput) {
        hero.setSp(hero.getSp() - userInput);
    }


    /**
     * upgrade particular characteristic
     *
     * @param characteristic concrete key needs to upgrade
     * @param hero           instance of particular hero
     * @param points         upgrade points
     */
    private static void upgradeCharacteristic(String characteristic, AbstractRace hero, int points) {
        Map<AbstractRace, Integer> arguments = new HashMap<>();
        arguments.put(hero, points);

        DistributionSwitch.getInstance()
                .getCharacteristicsSwitch()
                .get(characteristic)
                .accept(arguments);
    }


    /**
     * helper function to parse String to int
     *
     * @param number string that represented number
     * @return integer
     */
    private static int parseInt(String number) {
        return Integer.parseInt(number);
    }
}
