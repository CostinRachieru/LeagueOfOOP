package gamemap;

import hero.Hero;

import java.util.ArrayList;

public class LandCell extends Cell {
    public LandCell() {
        heroesInCell = new ArrayList<Hero>();
    }

    public void printCellType() {
        System.out.print("Land ");
    }
}
