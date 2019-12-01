package main;

import java.util.ArrayList;

import fileio.FileSystem;
import hero.Coordinates;
import hero.Hero;

public class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;
//    private final FileSystem fs;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
//        fs = new FileSystem(mInputPath, mOutputPath);
    }

    public final GameInput load() {
        int mapHeight = 0;
        int mapWidth = 0;
        ArrayList<String> map = new ArrayList<>();
        int nrHeroes = 0;
        ArrayList<String> playersType = new ArrayList<>();
        ArrayList<Coordinates> playersPosition = new ArrayList<>();
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
                playersPosition.add(new Coordinates(fs.nextInt(), fs.nextInt()));
            }

            nrRounds = fs.nextInt();

            for (int i = 0; i < nrRounds; ++i) {
                moves.add(fs.nextWord());
            }

            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(mapHeight, mapWidth, map, nrHeroes, playersType,
                playersPosition, moves);
    }
    public final void write(final ArrayList<Hero> heroes) {
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
            for (Hero hero : heroes) {
                fs.writeCharacter(hero.getType());
                if (hero.isAlive()) {
                    fs.writeCharacter(' ');
                    fs.writeInt(hero.getLevel());
                    fs.writeCharacter(' ');
                    fs.writeInt(hero.getExperience());
                    fs.writeCharacter(' ');
                    fs.writeInt(hero.getHealthPoints());
                    fs.writeCharacter(' ');
                    fs.writeInt(hero.getLocation().getLine());
                    fs.writeCharacter(' ');
                    fs.writeInt(hero.getLocation().getRow());
                } else {
                    fs.writeWord(" dead");
                }
                fs.writeNewLine();
            }
            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
