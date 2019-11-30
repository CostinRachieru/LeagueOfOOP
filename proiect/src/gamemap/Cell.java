package gamemap;

import hero.Hero;

import java.util.ArrayList;

public abstract class Cell {
    protected ArrayList<Hero> heroesInCell;
    protected boolean combatDone;

    public void addHero(Hero hero) {
        heroesInCell.add(hero);
    }

    public abstract boolean isCombat();

    public abstract void printCellType();


    public void heroLeave(Hero hero) {
        for (int i = 0; i < heroesInCell.size(); ++i) {
            if (heroesInCell.get(i).sameAs(hero)) {
                heroesInCell.remove(i);
            }
        }
    }

    public ArrayList<Hero> getHeroesInCell() {
        return heroesInCell;
    }
}
