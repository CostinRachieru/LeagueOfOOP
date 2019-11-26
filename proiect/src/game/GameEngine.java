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

    public static GameMap initMap(GameInput gameInput) {
        return new GameMap(gameInput.getMapHeight(), gameInput.getMapWidth(), gameInput.getMap());
    }

    public static ArrayList<Hero> initHeroes(GameInput gameInput) {
        HeroFactory heroFactory = HeroFactory.getInstance();
        int nrHeroes = gameInput.getNrHeroes();
        ArrayList<Hero> heroes = new ArrayList<>();
        ArrayList<String> playersType = gameInput.getPlayersType();
        ArrayList<Coordinates> playersPosition = gameInput.getPlayersPosition();
        for (int i = 0; i < nrHeroes; ++i) {
            int posX = playersPosition.get(i).getPosX();
            int posY = playersPosition.get(i).getPosY();
            heroes.add(heroFactory.createHero(playersType.get(i), posX, posY));
        }
        return heroes;
    }
}
