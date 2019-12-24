package main;

import java.util.ArrayList;

import fileio.FileSystem;
import hero.Coordinates;
import hero.Hero;


public class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
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
        ArrayList<String> angelsType = new ArrayList<>();
        ArrayList<Coordinates> angelsPosition =  new ArrayList<>();
        ArrayList<Integer> numberOfAngelsPerRound = new ArrayList<>();

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

            for (int i = 0; i < nrRounds; ++i) {
                int nrThisRound = fs.nextInt();
                numberOfAngelsPerRound.add(nrThisRound);
                for (int j = 0; j < nrThisRound; ++j) {
                    String angel = fs.nextWord();
                    String[] angelAndPosition = angel.split(",");
                    angelsType.add(angelAndPosition[0]);
                    int line = Integer.parseInt(angelAndPosition[1]);
                    int column = Integer.parseInt(angelAndPosition[2]);
                    angelsPosition.add(new Coordinates(line, column));
                }
            }

            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(mapHeight, mapWidth, map, playersType, playersPosition,
                moves, angelsType, angelsPosition, numberOfAngelsPerRound);
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
