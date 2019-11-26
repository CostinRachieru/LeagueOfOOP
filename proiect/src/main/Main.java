package main;

import game.GameEngine;
import gamemap.GameMap;
import hero.Hero;

import java.util.ArrayList;

public final class Main {
    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        int nrHeroes = gameInput.getNrHeroes();
        int nrRounds = gameInput.getNrRounds();
        GameMap map = GameEngine.initMap(gameInput);
        ArrayList<Hero> heroes = GameEngine.initHeroes(gameInput);
        map.spawnHeroes(heroes);
    }
}