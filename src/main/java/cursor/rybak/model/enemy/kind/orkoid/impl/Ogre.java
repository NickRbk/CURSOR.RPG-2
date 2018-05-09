package cursor.rybak.model.enemy.kind.orkoid.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.orkoid.Orkoids;

public class Ogre extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 10};

    public Ogre() {
        super(MonsterKinds.ORKOID.getKind(), Orkoids.OGRE.getName(),
                Orkoids.OGRE.getHealth(), Orkoids.OGRE.getInitiative(),
                Orkoids.OGRE.getXp(), Orkoids.OGRE.getLevel());
    }

    @Override
    public int attack() {
        // implement damage option, can stun 15% chance
        return 0;
    }
}
