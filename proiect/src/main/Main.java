package main;

import game.GameEngine;
import gamemap.Cell;
import gamemap.GameMap;
import hero.Coordinates;
import hero.Hero;

import java.util.ArrayList;

public final class Main {
    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        GameEngine.initMap(gameInput);

        ArrayList<Hero> heroes = GameEngine.initHeroes(gameInput);
        GameMap  map = GameMap.getInstance();
        map.spawnHeroes(heroes);
        GameEngine.doCombats(heroes);
        /**
         * Plays each round of the game after the heroes were spawned
         */
        int nrRounds = gameInput.getNrRounds();
        ArrayList<String> moves = gameInput.getMoves();
        for (int round = 0; round < nrRounds; ++round) {
            GameEngine.moveHeroes(round, moves, heroes);
            GameEngine.doCombats(heroes);
        }
    }
}