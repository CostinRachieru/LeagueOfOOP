package main;

import game.GameEngine;
import gamemap.GameMap;
import hero.Coordinates;
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
        }
        gameInputLoader.write(heroes);
        ArrayList<String> angelsType = gameInput.getAngelsType();
        ArrayList<Coordinates> angelsPosition = gameInput.getAngelsPosition();
        ArrayList<Integer> angelsPerRound = gameInput.getAngelsPerRound();
    }
}
