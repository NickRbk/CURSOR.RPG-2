package cursor.rybak.model.enemy.kind.undead.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.undead.Undeads;

public class BoneDragon extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {3, 10};

    public BoneDragon() {
        super(MonsterKinds.UNDEAD.getKind(), Undeads.BONE_DRAGON.getName(),
                Undeads.BONE_DRAGON.getHealth(), Undeads.BONE_DRAGON.getInitiative(),
                Undeads.BONE_DRAGON.getXp(), Undeads.BONE_DRAGON.getLevel());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
