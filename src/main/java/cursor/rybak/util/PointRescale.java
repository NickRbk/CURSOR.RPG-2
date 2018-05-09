package cursor.rybak.util;

import cursor.rybak.model.race.CalcConst;

public class PointRescale implements CalcConst {
    public static double rescaleXPperCharisma(int charisma, double xp) {

        // 2% XP gain for every two charisma points
        int remainder = charisma % 2;

        return remainder == 0
                ? ((INCREASE_XP_COEFFICIENT_PER_CHARISMA * charisma / 2) * xp)
                : ((INCREASE_XP_COEFFICIENT_PER_CHARISMA * (charisma - remainder) / 2) * xp);
    }

    public static int rescaleIPperCharisma(int charisma) {

        // 1 additional initiative point per 2 points
        int remainder = charisma % 2;

        return remainder == 0
                ? (charisma / 2)
                : ((charisma - remainder) / 2);
    }

    public static double rescaleHPperStamina(int stamina) {
        return INCREASE_HP_COEFFICIENT_PER_STAMINA * stamina;
    }

    public static double rescaleMPperIntellect(int intellect) {
        return INCREASE_MP_COEFFICIENT_PER_INTELLECT * intellect;
    }

    public static double rescaleRPperAgility(int agility) {
        return INCREASE_RP_COEFFICIENT_PER_AGILITY * agility;
    }

    public static double regenMPperIntellect(int totalIntellect) {
        return REGEN_MP_COEFFICIENT_PER_INTELLECT * totalIntellect;
    }

    public static double regenMPperConcentration(int totalConcentration) {
        return REGEN_MP_COEFFICIENT_PER_CONCENTRATION * totalConcentration;
    }

    public static double regenHPperStamina(int totalStamina) {
        return REGEN_HP_COEFFICIENT_PER_STAMINA * totalStamina;
    }

    public static double regenHPperConcentration(int totalConcentration) {
        return REGEN_HP_COEFFICIENT_PER_CONCENTRATION * totalConcentration;
    }

    public static double regenRPperConcentration(int totalConcentration) {
        return REGEN_RP_COEFFICIENT_PER_CONCENTRATION * totalConcentration;
    }
}
