package cursor.rybak.util;

import cursor.rybak.model.race.CalcConst;

public class PointRescale implements CalcConst {
    public static double rescaleXPperCharisma(int charisma, double xp) {

        // 2% XP gain for every two charisma points
        int remainder = charisma % 2;

        return remainder == 0
                ? ((increaseXPCoefficientPerCharisma * charisma / 2) * xp)
                : ((increaseXPCoefficientPerCharisma * (charisma - remainder) / 2) * xp);
    }

    public static double rescaleHPperStamina(int stamina) {
        return increaseHPCoefficientPerStamina * stamina;
    }

    public static double rescaleMPperIntellect(int intellect) {
        return increaseMPCoefficientPerIntellect * intellect;
    }

    public static double rescaleRPperAgility(int agility) {
        return increaseRPCoefficientPerAgility * agility;
    }

    public static double regenMPperIntellect(int totalIntellect) {
        return regenMPCoefficientPerIntellect * totalIntellect;
    }

    public static double regenMPperConcentration(int totalConcentration) {
        return regenMPCoefficientPerConcentration * totalConcentration;
    }

    public static double regenHPperStamina(int totalStamina) {
        return regenHPCoefficientPerStamina * totalStamina;
    }

    public static double regenHPperConcentration(int totalConcentration) {
        return regenHPCoefficientPerConcentration * totalConcentration;
    }

    public static double regenRPperConcentration(int totalConcentration) {
        return regenRPCoefficientPerConcentration * totalConcentration;
    }
}
