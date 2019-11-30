package gamemap;

import hero.Hero;

import java.util.ArrayList;

public class DesertCell extends Cell {
    public DesertCell() {
        heroesInCell = new ArrayList<Hero>();
    }

    public void printCellType() {
        System.out.print("Desert ");
    }
}
