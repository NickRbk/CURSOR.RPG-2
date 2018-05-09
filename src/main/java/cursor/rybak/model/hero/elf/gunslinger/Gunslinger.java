package cursor.rybak.model.hero.elf.gunslinger;

import cursor.rybak.model.common.Damage;
import cursor.rybak.model.hero.AbstractAbility;
import cursor.rybak.model.hero.elf.ElfProfession;
import cursor.rybak.model.hero.elf.gunslinger.abilities.map.GunslingerAbilitiesMap;
import cursor.rybak.model.race.kind.impl.Elf;
import lombok.Getter;

import java.util.Map;

public class Gunslinger extends Elf {
    @Getter
    Map<String, Map<String, AbstractAbility>> specialAttacks = GunslingerAbilitiesMap.getSpecialAttackMap();
    @Getter
    Map<String, Damage> attacks = GunslingerAbilitiesMap.getAttackMap();

    public Gunslinger() {
        super(ElfProfession.GUNSLINGER);
    }

    @Override
    public int attack() {
        return 0;
    }
}
