package cursor.rybak.model.race;

import cursor.rybak.model.common.CommonUnit;
import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.util.PointRescale;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
public abstract class AbstractRace implements CommonUnit, RaceInitValues {

    private double XPCoefficient = initXPCoefficient;

    private String race;
    private String heroKind;

    @Setter
    private String heroName;

    private double health = initValue; // health points (hp)
    private boolean isLeader;

    @Setter
    private double xp;

    @Setter
    private int sp = RaceInitValues.sp; // skill points (xp)

    private double mana = initValue; // manna point for spells (mp)
    private double rage = initValue; // rage points (rp)
    private int initiative;
    private int charisma;
    private int stamina;
    private int intellect;
    private int agility;
    private int concentration;

    @Setter
    private int level = RaceInitValues.level;

    @Setter
    private int prevLevelPoints = initLevelUpPoints;

    public AbstractRace(String race,
                        String heroKind,
                        int charisma,
                        int stamina,
                        int intellect,
                        int agility,
                        int concentration) {

        this.race = race;
        this.heroKind = heroKind;

        setCharisma(charisma);
        setStamina(stamina);
        setIntellect(intellect);
        setAgility(agility);
        setConcentration(concentration);
    }

    public void setLeader() {
        this.heroName = getHeroName() + "*";
        this.isLeader = true;
        this.XPCoefficient = leaderXPCoefficient;
    }

    public void setHealth(double health) {
        this.health = health < RaceInitValues.minValue ? RaceInitValues.minValue : health;
    }

    public void setMana(int mana) {
        this.mana = mana < RaceInitValues.minValue ? RaceInitValues.minValue : mana;
    }

    public void setRage(int rage) {
        this.rage = rage < RaceInitValues.minValue ? RaceInitValues.minValue : rage;
    }

    public abstract int attack();

    public abstract Map<String, Map<String, AbstractAbility>> getSpecialAttacks();

    public abstract Map<String, int[]> getAttacks();

    public void gainXp(double xp) {
        this.xp += xp + PointRescale.rescaleXPperCharisma(getCharisma(), xp);
    }

    public void setCharisma(int charisma) {
        this.charisma += charisma;
        this.initiative = PointRescale.rescaleIPperCharisma(getCharisma());

        // charisma > 40 allows to fear enemies
        // (0.75% chance per 2 points of charisma)
        // CODE WILL BE HERE
    }

    public void setStamina(int stamina) {
        this.stamina += stamina;
        this.health += PointRescale.rescaleHPperStamina(stamina);
    }

    public void setIntellect(int intellect) {
        this.intellect += intellect;
        this.mana += PointRescale.rescaleMPperIntellect(intellect);
    }

    public void setAgility(int agility) {
        this.agility += agility;
        this.rage += PointRescale.rescaleRPperAgility(agility);

        // chance to avoid hit 1% per 2 points
        // CODE WILL BE HERE
    }

    public void setConcentration(int concentration) {
        this.concentration += concentration;

        // 1 turn cd decrease per 25 points
        // CODE WILL BE HERE
    }

    public void regeneration() {
        this.health += PointRescale.regenHPperConcentration(getConcentration())
                + PointRescale.regenHPperStamina(getStamina());

        this.mana += PointRescale.regenMPperConcentration(getConcentration())
                + PointRescale.regenMPperIntellect(getIntellect());

        this.rage += PointRescale.regenRPperConcentration(getConcentration());
    }
}
