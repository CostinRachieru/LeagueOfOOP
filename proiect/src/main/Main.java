package main;

import angel.Angel;
import game.GameEngine;
import gamemap.GameMap;
import hero.Hero;
import observer.KillingMonitor;
import observer.HeroesLevelMonitor;
import observer.AngelKillingMonitor;
import observer.AngelHelpingHeroes;
import observer.AngelSpawningMonitor;
import observer.Observer;
import observer.RevivingMonitor;

import java.util.ArrayList;

public final class Main {
    private Main() {
    }
    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        GameEngine.initMap(gameInput);

        ArrayList<Hero> heroes = GameEngine.initHeroes(gameInput);
        Observer killingMonitor = new KillingMonitor(gameInputLoader);
        Observer heroesLevelMonitor = new HeroesLevelMonitor(gameInputLoader);
        Observer revivingMonitor = new RevivingMonitor(gameInputLoader);
        for (Hero hero : heroes) {
            hero.registerObserver(killingMonitor);
            hero.registerObserver(heroesLevelMonitor);
            hero.registerObserver(revivingMonitor);
        }
        ArrayList<ArrayList<Angel>> angels = GameEngine.initAngels(gameInput);
        Observer angelSpawningMonitor = new AngelSpawningMonitor(gameInputLoader);
        Observer angelHelpingHeroes = new AngelHelpingHeroes(gameInputLoader);
        Observer angelKillingMonitor = new AngelKillingMonitor(gameInputLoader);
        for (int i = 0; i < angels.size(); ++i) {
            for (int j = 0; j < angels.get(i).size(); ++j) {
                Angel angel = angels.get(i).get(j);
                angel.registerObserver(angelSpawningMonitor);
                angel.registerObserver(angelHelpingHeroes);
                angel.registerObserver(angelKillingMonitor);
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
