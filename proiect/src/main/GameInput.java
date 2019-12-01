package main;

import hero.Coordinates;

import java.util.ArrayList;

public class GameInput {
    private final int mapHeight;
    private final int mapWidth;
    private final ArrayList<String> map;
    private int nrHeroes;
    private final ArrayList<String> playersType;
    private final ArrayList<Coordinates> playersPosition;
    private final ArrayList<String> moves;

    public GameInput() {
        mapHeight = -1;
        mapWidth = -1;
        map = null;
        nrHeroes = -1;
        playersType = null;
        playersPosition = null;
        moves = null;
    }

    public GameInput(final int mapHeight, final int mapWidth,
                     final ArrayList<String> map, final int nrHeroes,
                     final ArrayList<String> playersType,
                     final ArrayList<Coordinates> playersPosition,
                     final ArrayList<String> moves) {
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
        this.map = map;
        this.nrHeroes = nrHeroes;
        this.playersType = playersType;
        this.playersPosition = playersPosition;
        this.moves = moves;
    }

    public final int getMapHeight() {
        return mapHeight;
    }

    public final int getMapWidth() {
        return mapWidth;
    }

    public final ArrayList<String> getMap() {
        return map;
    }

    public final int getNrHeroes() {
        return nrHeroes;
    }

    public final ArrayList<String> getPlayersType() {
        return playersType;
    }

    public final ArrayList<Coordinates> getPlayersPosition() {
        return playersPosition;
    }

    public final ArrayList<String> getMoves() {
        return moves;
    }
}
