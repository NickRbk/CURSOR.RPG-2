package cursor.rybak.model.enemy.kind.creature.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.creature.Creatures;

public class Doomguard extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 6};

    public Doomguard() {
        super(MonsterKinds.CREATURE.getKind(), Creatures.DOOMGUARD.getName(),
                Creatures.DOOMGUARD.getHealth(), Creatures.DOOMGUARD.getInitiative(),
                Creatures.DOOMGUARD.getXp(), Creatures.DOOMGUARD.getLevel());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
