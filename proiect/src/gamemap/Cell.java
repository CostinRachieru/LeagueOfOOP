package gamemap;

import hero.Hero;

import java.util.ArrayList;

public class Cell {
    protected ArrayList<Hero> heroesInCell;
    protected Cell() {}

    public void addHero(Hero hero) {
        heroesInCell.add(hero);
    }
}
