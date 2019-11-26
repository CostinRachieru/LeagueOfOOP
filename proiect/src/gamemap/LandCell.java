package gamemap;

import hero.Hero;

import java.util.ArrayList;

public class LandCell extends Cell {

    public LandCell() {
        heroesInCell = new ArrayList<Hero>();
        System.out.println("L");
    }
}
