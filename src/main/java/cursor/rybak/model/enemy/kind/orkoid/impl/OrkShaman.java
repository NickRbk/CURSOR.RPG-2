package cursor.rybak.model.enemy.kind.orkoid.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.orkoid.Orkoids;

public class OrkShaman extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 6};
    private static final int[] DAMAGE_OPTIONS_EXTRA = {2, 10};
    private int coolDown = 3;

    public OrkShaman() {
        super(MonsterKinds.ORKOID.getKind(), Orkoids.ORK_SHAMAN.getName(),
                Orkoids.ORK_SHAMAN.getHealth(), Orkoids.ORK_SHAMAN.getInitiative(),
                Orkoids.ORK_SHAMAN.getXp(), Orkoids.ORK_SHAMAN.getLevel());
    }

    @Override
    public int attack() {
        // implement damage option, can cast 'bloodlust' on friendly ork
        // to improve his damage to [2;10]
        return 0;
    }
}
