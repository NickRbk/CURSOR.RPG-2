package cursor.rybak.model.hero;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class AbstractAbility {
    private String name;
    private int energyConsumption;
    private int[] damageOptions;

    @Setter
    private int coolDown;

    /**
     * constructor for abstract
     * class AbstractAbility
     * (some spells or skills)
     *
     * @param name              name of spell
     * @param energyConsumption how much mana / rage needs (mp/rp)
     * @param damageOptions     destruction options [min value, max value]
     * @param coolDown          pause for recovery (cd)
     */
    public AbstractAbility(String name,
                           int energyConsumption,
                           int[] damageOptions,
                           int coolDown) {

        this.name = name;
        this.energyConsumption = energyConsumption;
        this.damageOptions = damageOptions;
        this.coolDown = coolDown;
    }

    public abstract void specialAbility();
}
