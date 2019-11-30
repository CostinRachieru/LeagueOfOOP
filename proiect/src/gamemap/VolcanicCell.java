package gamemap;

import hero.Hero;

import java.util.ArrayList;

public class VolcanicCell extends Cell {
    public VolcanicCell() {
        heroesInCell = new ArrayList<Hero>();
    }

    public void printCellType() {
        System.out.print("Volcanic ");
    }
}
