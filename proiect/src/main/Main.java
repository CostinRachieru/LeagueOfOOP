package main;

import angel.Angel;
import game.GameEngine;
import gamemap.GameMap;
import hero.Hero;
import observer.GrandMagician;

import java.util.ArrayList;

public final class Main {
    private Main() {
    }
    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        GameEngine.initMap(gameInput);

        /**
         * Initialize heroes and angels and register the observers to them.
         */
        ArrayList<Hero> heroes = GameEngine.initHeroes(gameInput);
        GrandMagician greatMagician = new GrandMagician(gameInputLoader);
        for (Hero hero : heroes) {
            hero.registerObserver(greatMagician.getKillingMonitor());
            hero.registerObserver(greatMagician.getHeroesLevelMonitor());
            hero.registerObserver(greatMagician.getRevivingMonitor());
        }
        ArrayList<ArrayList<Angel>> angels = GameEngine.initAngels(gameInput);
        for (int i = 0; i < angels.size(); ++i) {
            for (int j = 0; j < angels.get(i).size(); ++j) {
                Angel angel = angels.get(i).get(j);
                angel.registerObserver(greatMagician.getAngelSpawningMonitor());
                angel.registerObserver(greatMagician.getAngelHelpingHeroes());
                angel.registerObserver(greatMagician.getAngelKillingMonitor());
            }
        }
        GameMap  map = GameMap.getInstance();
        map.spawnHeroes(heroes);
        /**
         * Plays each round of the game.
         */
        ArrayList<String> moves = gameInput.getMoves();
        int nrRounds = moves.size();
        for (int round = 0; round < nrRounds; ++round) {
            gameInputLoader.write("~~ Round " + (round + 1) + " ~~");
            GameEngine.moveHeroes(round, moves, heroes);
            if (round != 0) {
                GameEngine.heroesChoseStrategy(heroes);
            }
            GameEngine.doCombats(heroes);
            GameEngine.helpHeroes(angels, round);
            gameInputLoader.write("");
        }
        gameInputLoader.write("~~ Results ~~");
        gameInputLoader.write(heroes);
    }
}
