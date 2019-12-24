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
    private final ArrayList<String> angelsType;
    private final ArrayList<Coordinates> angelsPosition;
    private final ArrayList<Integer> angelsPerRound;

    public GameInput() {
        mapHeight = -1;
        mapWidth = -1;
        map = null;
        nrHeroes = -1;
        playersType = null;
        playersPosition = null;
        moves = null;
        angelsType = null;
        angelsPosition = null;
        angelsPerRound = null;
    }

    public GameInput(final int mapHeight, final int mapWidth,
                     final ArrayList<String> map, final ArrayList<String> playersType,
                     final ArrayList<Coordinates> playersPosition,
                     final ArrayList<String> moves, final ArrayList<String> angelsType,
                     final ArrayList<Coordinates> angelsPosition,
                     final ArrayList<Integer> angelsPerRound) {
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
        this.map = map;
        this.nrHeroes = playersType.size();
        this.playersType = playersType;
        this.playersPosition = playersPosition;
        this.moves = moves;
        this.angelsType = angelsType;
        this.angelsPosition = angelsPosition;
        this.angelsPerRound = angelsPerRound;
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

    public final ArrayList<String> getAngelsType() {
        return angelsType;
    }

    public final ArrayList<Coordinates> getAngelsPosition() {
        return angelsPosition;
    }

    public final ArrayList<Integer> getAngelsPerRound() {
        return angelsPerRound;
    }
}
