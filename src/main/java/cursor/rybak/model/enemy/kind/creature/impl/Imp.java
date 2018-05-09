package cursor.rybak.model.enemy.kind.creature.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.creature.Creatures;

public class Imp extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 6};

    public Imp() {
        super(MonsterKinds.CREATURE.getKind(), Creatures.IMP.getName(),
                Creatures.IMP.getHealth(), Creatures.IMP.getInitiative(),
                Creatures.IMP.getXp(), Creatures.IMP.getLevel());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
