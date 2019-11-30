package gamemap;

import common.Constants;
import hero.Coordinates;
import hero.Hero;
import hero.HeroFactory;

import java.util.ArrayList;

public class GameMap {
    private static GameMap instance = null;
    private int height;
    private int width;
    private ArrayList<ArrayList<Cell>> terrain;

    private GameMap() {
    }

    public static GameMap getInstance() {
        if (instance == null) {
            instance = new GameMap();
        }
        return instance;
    }

    public void initGameMap(int mapHeight, int mapWidth, ArrayList<String> map) {
        height = mapHeight;
        width = mapWidth;
        CellFactory cellFactory = CellFactory.getInstance();
        terrain = new ArrayList<>(height);
        for (int i = 0; i < height; ++i) {
            terrain.add(new ArrayList<>(width));
            for (int j = 0; j < width; ++j) {
                terrain.get(i).add(cellFactory.createCell(map.get(i).charAt(j)));
            }
        }
    }
    public void spawnHeroes(ArrayList<Hero> heroes) {
        for (int i = 0; i < heroes.size(); ++i) {
            Hero hero = heroes.get(i);
            Coordinates location = hero.getLocation();
            getCell(location).addHero(hero);
        }
    }

    public Cell getCell(Coordinates position) {
        return terrain.get(position.getLine()).get(position.getRow());
    }

    public void heroLeaveCell(Hero hero, Coordinates location) {
        Cell cell = getCell(location);
        cell.heroLeave(hero);
    }

    public void heroGoToCell(Hero hero, Coordinates location) {
        Cell cell = getCell(location);
        cell.addHero(hero);
    }

    public boolean isCombat(Coordinates location) {
        if (getCell(location).isCombat()) {
            return true;
        }
        return false;
    }

    public void doLandModifier(Coordinates location) {

    }

    public ArrayList<Hero> getHeroesInCell(Coordinates location) {
        return getCell(location).getHeroesInCell();
    }
}
