package cursor.rybak.model.enemy.kind.undead.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.undead.Undeads;

public class Lich extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 6};

    public Lich() {
        super(MonsterKinds.UNDEAD.getKind(), Undeads.LICH.getName(),
                Undeads.LICH.getHealth(), Undeads.LICH.getInitiative(),
                Undeads.LICH.getXp(), Undeads.LICH.getLevel());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
