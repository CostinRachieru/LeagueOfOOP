package gamemap;

import hero.Coordinates;
import hero.Hero;

import java.util.ArrayList;

public class GameMap {
    private int height;
    private int width;
    private ArrayList<ArrayList<Cell>> terrain;

    public GameMap(int mapHeight, int mapWidth, ArrayList<String> map) {
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
            terrain.get(location.getPosX()).get(location.getPosY()).addHero(hero);
        }
    }
}
