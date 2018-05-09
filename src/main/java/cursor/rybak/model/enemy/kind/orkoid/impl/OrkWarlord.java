package cursor.rybak.model.enemy.kind.orkoid.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.orkoid.Orkoids;

public class OrkWarlord extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 6};

    public OrkWarlord() {
        super(MonsterKinds.ORKOID.getKind(), Orkoids.ORK_WARLORD.getName(),
                Orkoids.ORK_WARLORD.getHealth(), Orkoids.ORK_WARLORD.getInitiative(),
                Orkoids.ORK_WARLORD.getXp(), Orkoids.ORK_WARLORD.getLevel());
    }

    @Override
    public int attack() {
        // implement damage option, with splash (hit 1 additional target)
        return 0;
    }
}
