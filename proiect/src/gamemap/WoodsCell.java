package gamemap;

import hero.Hero;

import java.util.ArrayList;

public class WoodsCell extends Cell {
    public WoodsCell() {
        heroesInCell = new ArrayList<Hero>();
    }

    public void printCellType() {
        System.out.print("Woods ");
    }
}
