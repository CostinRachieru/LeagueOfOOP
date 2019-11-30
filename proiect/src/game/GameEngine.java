package game;

import gamemap.GameMap;
import hero.Coordinates;
import hero.Hero;
import hero.HeroFactory;
import main.GameInput;

import java.util.ArrayList;

public final class GameEngine {
    private GameEngine() {
    }

    public static void initMap(GameInput gameInput) {
        GameMap map = GameMap.getInstance();
        map.initGameMap(gameInput.getMapHeight(), gameInput.getMapWidth(), gameInput.getMap());
    }

    public static ArrayList<Hero> initHeroes(GameInput gameInput) {
        HeroFactory heroFactory = HeroFactory.getInstance();
        int nrHeroes = gameInput.getNrHeroes();
        ArrayList<Hero> heroes = new ArrayList<>();
        ArrayList<String> playersType = gameInput.getPlayersType();
        ArrayList<Coordinates> playersPosition = gameInput.getPlayersPosition();
        for (int i = 0; i < nrHeroes; ++i) {
            int row = playersPosition.get(i).getRow();
            int line = playersPosition.get(i).getLine();
            heroes.add(heroFactory.createHero(playersType.get(i), line, row, i));
        }
        return heroes;
    }
}
