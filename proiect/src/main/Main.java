package main;

import angel.Angel;
import game.GameEngine;
import gamemap.GameMap;
import hero.Hero;

import java.util.ArrayList;

public final class Main {
    private Main() {
    }
    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        GameEngine.initMap(gameInput);

        ArrayList<Hero> heroes = GameEngine.initHeroes(gameInput);
        ArrayList<ArrayList<Angel>> angels = GameEngine.initAngels(gameInput);
        GameMap  map = GameMap.getInstance();
        map.spawnHeroes(heroes);
        /**
         * Plays each round of the game.
         */
        ArrayList<String> moves = gameInput.getMoves();
        int nrRounds = moves.size();
        for (int round = 0; round < nrRounds; ++round) {
            GameEngine.moveHeroes(round, moves, heroes);
            GameEngine.doCombats(heroes);
            GameEngine.helpHeroes(angels, round);
        }
        gameInputLoader.write(heroes);
    }
}
