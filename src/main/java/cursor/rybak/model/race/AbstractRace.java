package cursor.rybak.model.race;

import cursor.rybak.model.common.CommonUnit;
import cursor.rybak.model.common.Damage;
import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.util.PointRescale;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
public abstract class AbstractRace implements CommonUnit, RaceInitValues {

    private double xpCoefficient = INIT_XP_COEFFICIENT;

    private String race;
    private String heroKind;

    @Setter
    private String heroName;

    private double health = INIT_VALUE; // health points (hp)
    private boolean isLeader;

    @Setter
    private double xp;

    @Setter
    private int sp = SP; // skill points (xp)

    private double mana = INIT_VALUE; // manna point for spells (mp)
    private double rage = INIT_VALUE; // rage points (rp)
    private int initiative;
    private int charisma;
    private int stamina;
    private int intellect;
    private int agility;
    private int concentration;

    @Setter
    private int level = MIN_LEVEL;

    @Setter
    private int prevLevelPoints = INIT_LEVEL_UP_POINTS;

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
        this.xpCoefficient = LEADER_XP_COEFFICIENT;
    }

    public void setHealth(double health) {
        this.health = health < MIN_VALUE ? MIN_VALUE : health;
    }

    public void setMana(int mana) {
        this.mana = mana < MIN_VALUE ? MIN_VALUE : mana;
    }

    public void setRage(int rage) {
        this.rage = rage < MIN_VALUE ? MIN_VALUE : rage;
    }

    public abstract int attack();

    public abstract Map<String, Map<String, AbstractAbility>> getSpecialAttacks();

    public abstract Map<String, Damage> getAttacks();

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
