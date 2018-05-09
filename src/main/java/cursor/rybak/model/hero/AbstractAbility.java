package cursor.rybak.model.hero;

import cursor.rybak.model.common.Damage;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class AbstractAbility {
    private String name;
    private int energyConsumption;
    private Damage damage;

    @Setter
    private int coolDown;

    /**
     * constructor for abstract
     * class AbstractAbility
     * (some spells or skills)
     *
     * @param name              name of spell
     * @param energyConsumption how much mana / rage needs (mp/rp)
     * @param damage            damage class (return current damage)
     * @param coolDown          pause for recovery (cd)
     */
    public AbstractAbility(String name,
                           int energyConsumption,
                           Damage damage,
                           int coolDown) {

        this.name = name;
        this.energyConsumption = energyConsumption;
        this.damage = damage;
        this.coolDown = coolDown;
    }

    public abstract void specialAbility();
}
