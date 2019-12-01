package gamemap;

import hero.Hero;

import java.util.ArrayList;

public abstract class Cell {
    protected ArrayList<Hero> heroesInCell;
    protected boolean combatDone;

    public final void addHero(final Hero hero) {
        heroesInCell.add(hero);
    }

    public abstract boolean isCombat();

    public final void heroLeave(final Hero hero) {
        for (int i = 0; i < heroesInCell.size(); ++i) {
            if (heroesInCell.get(i).sameAs(hero)) {
                heroesInCell.remove(i);
            }
        }
    }

    public final ArrayList<Hero> getHeroesInCell() {
        return heroesInCell;
    }
}
