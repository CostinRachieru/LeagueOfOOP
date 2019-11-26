package main;

import gamemap.GameMap;

public final class Main {
    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        GameMap map = new GameMap(gameInput.getMapHeight(), gameInput.getMapWidth(), gameInput.getMap());
    }
}