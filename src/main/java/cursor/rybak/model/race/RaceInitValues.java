package cursor.rybak.model.race;

public interface RaceInitValues {
    int INIT_LEVEL_UP_POINTS = 100;
    double INIT_XP_COEFFICIENT = 0.3;
    double LEADER_XP_COEFFICIENT = 0.4;
    int MIN_VALUE = 0;
    int INIT_VALUE = 100;
    int SP = 10;
    int MIN_LEVEL = 1;
    int MAX_LEVEL = 10;

    String[] keyToUpgrade = {Characteristics.CHARISMA, Characteristics.STAMINA, Characteristics.INTELLECT,
            Characteristics.AGILITY, Characteristics.CONCENTRATION, Characteristics.INFO};
}
