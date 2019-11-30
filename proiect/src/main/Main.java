package main;

import game.GameEngine;
import gamemap.GameMap;
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

        /**
         * Plays each round of the game after the heroes were spawned
         */
        int nrRounds = gameInput.getNrRounds();
        ArrayList<String> moves = gameInput.getMoves();
        for (int round = 0; round < nrRounds; ++round) {
            String movesThisRound = moves.get(round);
            int whichHero = 0;
            /**
             * Moves every player to the desired location.
             */
            for (Hero hero : heroes) {
                char nextLocation = movesThisRound.charAt(whichHero);
                hero.moveTo(nextLocation);
                whichHero++;
            }
        }
    }
}