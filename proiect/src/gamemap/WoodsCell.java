package gamemap;

import hero.Hero;

import java.util.ArrayList;

public class WoodsCell extends Cell {
    public WoodsCell() {
        heroesInCell = new ArrayList<Hero>();
        System.out.println("W");
    }
}
