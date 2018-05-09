package cursor.rybak.model.hero.elf.mage;

import cursor.rybak.model.common.Damage;
import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.elf.ElfProfession;
import cursor.rybak.model.hero.elf.mage.abilities.map.MagAbilitiesMap;
import cursor.rybak.model.race.kind.impl.Elf;
import lombok.Getter;

import java.util.Map;

public class Mage extends Elf {
    @Getter
    Map<String, Map<String, AbstractAbility>> specialAttacks = MagAbilitiesMap.getSpecialAttackMap();
    @Getter
    Map<String, Damage> attacks = MagAbilitiesMap.getAttackMap();

    public Mage() {
        super(ElfProfession.MAGE);
    }

    @Override
    public int attack() {
        return 0;
    }
}
