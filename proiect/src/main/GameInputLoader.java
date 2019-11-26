package main;

import java.util.ArrayList;

import fileio.FileSystem;

public class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        int mapHeight = 0;
        int mapWidth = 0;
        ArrayList<String> map = new ArrayList<>();
        int nrHeroes = 0;
        ArrayList<String> playersType = new ArrayList<>();
        ArrayList<ArrayList<Integer>> playersPosition = new
                ArrayList<ArrayList<Integer>>();
        int nrRounds = 0;
        ArrayList<String> moves = new ArrayList<>();

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            mapHeight = fs.nextInt();
            mapWidth = fs.nextInt();

            for (int i = 0; i < mapHeight; ++i) {
                map.add(fs.nextWord());
            }

            nrHeroes = fs.nextInt();

            for (int i = 0; i < nrHeroes; ++i) {
                playersType.add(fs.nextWord());
                ArrayList<Integer> position = new ArrayList<>();
                position.add(fs.nextInt());
                position.add(fs.nextInt());
                playersPosition.add(position);
            }

            nrRounds = fs.nextInt();

            for (int i = 0; i < nrRounds; ++i) {
                moves.add(fs.nextWord());
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(mapHeight, mapWidth, map, nrHeroes, playersType,
                playersPosition, nrRounds, moves);
    }
}
