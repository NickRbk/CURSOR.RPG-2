package cursor.rybak.model.enemy.kind.creature.impl;

import cursor.rybak.model.enemy.AbstractMonster;
import cursor.rybak.model.enemy.MonsterKinds;
import cursor.rybak.model.enemy.kind.creature.Creatures;

public class DoomSpider extends AbstractMonster {
    private static final int[] DAMAGE_OPTIONS = {0, 3};

    public DoomSpider() {
        super(MonsterKinds.CREATURE.getKind(), Creatures.DOOM_SPIDER.getName(),
                Creatures.DOOM_SPIDER.getHealth(), Creatures.DOOM_SPIDER.getInitiative(),
                Creatures.DOOM_SPIDER.getXp(), Creatures.DOOM_SPIDER.getLevel());
    }

    @Override
    public int attack() {
        // implement damage option
        return 0;
    }
}
