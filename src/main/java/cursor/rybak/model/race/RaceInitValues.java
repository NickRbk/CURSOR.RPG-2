package cursor.rybak.model.race;

public interface RaceInitValues {
    int initLevelUpPoints = 100;
    double initXPCoefficient = 0.3;
    double leaderXPCoefficient = 0.4;
    int minValue = 0;
    int initValue = 100;
    int sp = 10;
    int level = 1;
    int maxLevel = 10;

    String[] keyToUpgrade = {Characteristics.CHARISMA, Characteristics.STAMINA, Characteristics.INTELLECT,
            Characteristics.AGILITY, Characteristics.CONCENTRATION, "INFO"};
}
