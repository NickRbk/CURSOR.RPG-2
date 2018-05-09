package cursor.rybak.model.hero.dwarf.warrior.abilities;

import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.dwarf.DwarfAbility;

public class WhirlingAxe extends AbstractAbility {

    public WhirlingAxe() {
        super(DwarfAbility.WHIRLING_AXE.getName(), DwarfAbility.WHIRLING_AXE.getEnergyConsumption(),
                DwarfAbility.WHIRLING_AXE.getDamage(), DwarfAbility.WHIRLING_AXE.getCoolDown());
    }

    @Override
    public void specialAbility() {
        // implement throw axe into nearest enemy,
        // deal additional damage [2;6]
    }
}
