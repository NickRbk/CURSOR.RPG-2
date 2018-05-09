package cursor.rybak.model.enemy.kind.orkoid.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.orkoid.Orkoids;

public class Ork extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 6};

    public Ork() {
        super(MonsterKinds.ORKOID.getKind(), Orkoids.ORK.getName(),
                Orkoids.ORK.getHealth(), Orkoids.ORK.getInitiative(),
                Orkoids.ORK.getXp(), Orkoids.ORK.getLevel());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
