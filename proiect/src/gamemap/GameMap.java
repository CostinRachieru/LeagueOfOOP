package gamemap;

import hero.Coordinates;
import hero.Hero;

import java.util.ArrayList;

public final class GameMap {
    private static GameMap instance = null;
    private static int height;
    private static int width;
    private ArrayList<ArrayList<Cell>> terrain;

    private GameMap() {
    }

    public static GameMap getInstance() {
        if (instance == null) {
            instance = new GameMap();
        }
        return instance;
    }

    public void initGameMap(final int mapHeight, final int mapWidth, final ArrayList<String> map) {
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
    public void spawnHeroes(final ArrayList<Hero> heroes) {
        for (int i = 0; i < heroes.size(); ++i) {
            Hero hero = heroes.get(i);
            Coordinates location = hero.getLocation();
            getCell(location).addHero(hero);
        }
    }

    public void heroLeaveCell(final Hero hero, final Coordinates location) {
        Cell cell = getCell(location);
        cell.heroLeave(hero);
    }

    public void heroGoToCell(final Hero hero, final Coordinates location) {
//        if (location.getRow() >= 0 && location.getLine() >= 0) {
            Cell cell = getCell(location);
            cell.addHero(hero);
//        }
    }

    public boolean isCombat(final Coordinates location) {
        if (location.getRow() >= 0 && location.getLine() >= 0) {
            if (getCell(location).isCombat()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Hero> getHeroesInCell(final Coordinates location) {
        return getCell(location).getHeroesInCell();
    }

    public Cell getCell(final Coordinates position) {
        return terrain.get(position.getLine()).get(position.getRow());
    }
}
