package game;

import angel.Angel;
import angel.AngelFactory;
import gamemap.GameMap;
import hero.Coordinates;
import hero.Hero;
import hero.HeroFactory;
import main.GameInput;

import java.util.ArrayList;

public final class GameEngine {
    private GameEngine() {
    }

    public static void initMap(final GameInput gameInput) {
        GameMap map = GameMap.getInstance();
        map.initGameMap(gameInput.getMapHeight(), gameInput.getMapWidth(), gameInput.getMap());
    }

    public static ArrayList<Hero> initHeroes(final GameInput gameInput) {
        HeroFactory heroFactory = HeroFactory.getInstance();
        int nrHeroes = gameInput.getNrHeroes();
        ArrayList<Hero> heroes = new ArrayList<>();
        ArrayList<String> playersType = gameInput.getPlayersType();
        ArrayList<Coordinates> playersPosition = gameInput.getPlayersPosition();
        for (int i = 0; i < nrHeroes; ++i) {
            int row = playersPosition.get(i).getRow();
            int line = playersPosition.get(i).getLine();
            heroes.add(heroFactory.createHero(playersType.get(i), line, row, i));
        }
        return heroes;
    }

    public static ArrayList<ArrayList<Angel>> initAngels(final GameInput gameInput) {
        ArrayList<String> angelsType = gameInput.getAngelsType();
        ArrayList<Coordinates> angelsPosition = gameInput.getAngelsPosition();
        ArrayList<Integer> angelsPerRound = gameInput.getAngelsPerRound();
        int nrRounds = angelsPerRound.size();
        ArrayList<ArrayList<Angel>> angels = new ArrayList<>(nrRounds);
        int counter = 0;
        for (int i = 0; i < nrRounds; ++i) {
            int angelsThisRound = angelsPerRound.get(i);
            angels.add(new ArrayList<>(angelsThisRound));
            for (int j = 0; j < angelsThisRound; ++j) {
                angels.get(i).add(AngelFactory.createAngel(angelsType.get(counter),
                        angelsPosition.get(counter)));
                counter++;
            }
        }
        return angels;
    }

    public static void moveHeroes(final int round, final ArrayList<String> moves,
                                  final ArrayList<Hero> heroes) {
        String movesThisRound = moves.get(round);
        int whichHero = 0;
        /**
         * Moves every player to the desired location if not stunned.
         */
        for (Hero hero : heroes) {
            hero.sufferDamageOverTime();
            char nextLocation = movesThisRound.charAt(whichHero);
            if (hero.isAlive()) {
                if (!hero.isNowStunned()) {
                    hero.moveTo(nextLocation);
                }
            }
            whichHero++;
        }
    }

    public static void doCombats(final ArrayList<Hero> heroes) {
        GameMap map = GameMap.getInstance();
        for (Hero hero : heroes) {
            if (hero.isAlive()) {
                Coordinates location = hero.getLocation();
                if (map.isCombat(location)) {
                    ArrayList<Hero> heroesToFight = map.getHeroesInCell(location);
                    Hero firstHero = heroesToFight.get(0);
                    Hero secondHero = heroesToFight.get(1);
                    secondHero.isAttackedBy(firstHero);
                    firstHero.isAttackedBy(secondHero);
                    if (firstHero.isAlive() && !secondHero.isAlive()) {
                        firstHero.kill(secondHero);
                    }
                    if (secondHero.isAlive() && !firstHero.isAlive()) {
                        secondHero.kill(firstHero);
                    }
                    firstHero.increaseCriticalCount();
                    secondHero.increaseCriticalCount();
                }
            }
        }
    }

    public static void helpHeroes(final ArrayList<ArrayList<Angel>> angels, final int round) {
        GameMap map = GameMap.getInstance();
        ArrayList<Angel> angelsThisRound = angels.get(round);
        for (Angel angel : angelsThisRound) {
            Coordinates angelLocation = angel.getLocation();
            ArrayList<Hero> heroesInCell = map.getHeroesInCell(angelLocation);
            for (int i = 0; i < heroesInCell.size(); ++i) {
                Hero hero = heroesInCell.get(i);
                System.out.print(hero.getType() + ": " + hero.getHealthPoints() + " - ");
                hero.acceptHelp(angel);
                System.out.println(hero.getHealthPoints());
            }
            System.out.println();
        }
    }
    public static void heroesChoseStrategy(final ArrayList<Hero> heroes) {
        for (Hero hero : heroes) {
            hero.choseStrategy();
            hero.applyStrategy();
        }
    }
}
