package cursor.rybak.model.enemy.kind.undead.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.undead.Undeads;

public class Skeleton extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 6};

    public Skeleton() {
        super(MonsterKinds.UNDEAD.getKind(), Undeads.SKELETON.getName(),
                Undeads.SKELETON.getHealth(), Undeads.SKELETON.getInitiative(),
                Undeads.SKELETON.getXp(), Undeads.SKELETON.getLevel());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
