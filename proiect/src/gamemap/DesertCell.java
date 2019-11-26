package gamemap;

import hero.Hero;

import java.util.ArrayList;

public class DesertCell extends Cell {

    public DesertCell() {
        heroesInCell = new ArrayList<Hero>();
        System.out.println("D");
    }
}
