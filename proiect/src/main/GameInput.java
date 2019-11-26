package main;

import java.util.ArrayList;

public class GameInput {
    private final int mapHeight;
    private final int mapWidth;
    private final ArrayList<String> map;
    private int nrHeroes;
    private final ArrayList<String> playersType;
    private final ArrayList<ArrayList<Integer>> playersPosition;
    private final int nrRounds;
    private final ArrayList<String> moves;

    public GameInput() {
        mapHeight = -1;
        mapWidth = -1;
        map = null;
        nrHeroes = -1;
        playersType = null;
        playersPosition = null;
        nrRounds = -1;
        moves = null;
    }

    public GameInput(final int mapHeight, final int mapWidth,
                     final ArrayList<String> map, final int nrHeroes,
                     final ArrayList<String> playersType,
                     final ArrayList<ArrayList<Integer>> playersPosition,
                     final int nrRounds, final ArrayList<String> moves) {
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
        this.map = map;
        this.nrHeroes = nrHeroes;
        this.playersType = playersType;
        this.playersPosition = playersPosition;
        this.nrRounds = nrRounds;
        this.moves = moves;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public ArrayList<String> getMap() {
        return map;
    }

    public int getNrHeroes() {
        return nrHeroes;
    }

    public ArrayList<String> getPlayersType() {
        return playersType;
    }

    public ArrayList<ArrayList<Integer>> getPlayersPosition() {
        return playersPosition;
    }

    public int getNrRounds() {
        return nrRounds;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }
}
