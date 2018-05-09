package cursor.rybak.model.enemy.kind.creature.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.creature.Creatures;

public class BlackDragon extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {3, 10};

    public BlackDragon() {
        super(MonsterKinds.CREATURE.getKind(), Creatures.BLACK_DRAGON.getName(),
                Creatures.BLACK_DRAGON.getHealth(), Creatures.BLACK_DRAGON.getInitiative(),
                Creatures.BLACK_DRAGON.getXp(), Creatures.BLACK_DRAGON.getLevel());

        this.setSpellImmune(true);
    }

    @Override
    public int attack() {
        // implement damage option, Spell immune
        return 0;
    }
}
