package cursor.rybak.model.enemy.kind.creature.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.creature.Creatures;

public class Minotaur extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {2, 6};

    public Minotaur() {
        super(MonsterKinds.CREATURE.getKind(), Creatures.MINOTAUR.getName(),
                Creatures.MINOTAUR.getHealth(), Creatures.MINOTAUR.getInitiative(),
                Creatures.MINOTAUR.getXp(), Creatures.MINOTAUR.getLevel());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
