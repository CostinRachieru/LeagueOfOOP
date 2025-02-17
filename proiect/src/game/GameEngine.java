package game;

import angel.Angel;
import angel.AngelFactory;
import common.Constants;
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
         * Moves every player to the desired location if not stunned and take the over time damage.
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
                    int alreadyFoundOne = 0;
                    /**There can be more than 2 players in a cell (but maximum 2 alive), so
                     * the program needs to find those 2 players alive.
                     */
                    if (heroesToFight.size() > 2) {
                        for (int i = 0; i < heroesToFight.size(); ++i) {
                            if (heroesToFight.get(i).isAlive() && alreadyFoundOne == 0) {
                                firstHero = heroesToFight.get(i);
                                alreadyFoundOne = 1;
                            } else {
                                if (heroesToFight.get(i).isAlive() && alreadyFoundOne == 1) {
                                    secondHero = heroesToFight.get(i);
                                    break;
                                }
                            }
                        }
                    }
                    secondHero.isAttackedBy(firstHero);
                    firstHero.isAttackedBy(secondHero);
                    if (!secondHero.isAlive() && firstHero.isAlive()) {
                        firstHero.kill(secondHero);
                    }
                    if (!firstHero.isAlive() && secondHero.isAlive()) {
                        secondHero.kill(firstHero);
                    }
                    if (!firstHero.isAlive() && !secondHero.isAlive()) {
                        int currentFirstHeroLevel = firstHero.getLevel();
                        int currentSecondHeroLevel = secondHero.getLevel();
                        firstHero.killThemselves(secondHero);
                        secondHero.killThemselves(firstHero);
                        firstHero.experienceGainedKillThemselves(currentFirstHeroLevel,
                                currentSecondHeroLevel);
                        secondHero.experienceGainedKillThemselves(currentSecondHeroLevel,
                                currentFirstHeroLevel);
                    }
                    firstHero.increaseCriticalCount();
                    secondHero.increaseCriticalCount();
                }
            }
        }
    }

    /** All the angels on the map act upon the heores.
     * @param angels
     * @param round
     */
    public static void helpHeroes(final ArrayList<ArrayList<Angel>> angels, final int round) {
        GameMap map = GameMap.getInstance();
        ArrayList<Angel> angelsThisRound = angels.get(round);
        for (Angel angel : angelsThisRound) {
            angel.notifyObserverSpawn();
            Coordinates angelLocation = angel.getLocation();
            ArrayList<Hero> heroesInCell = map.getHeroesInCell(angelLocation);
            int lastMinId = -1;
            for (int i = 0; i < heroesInCell.size(); ++i) {
                Hero currentHeroHelped = heroesInCell.get(0);
                int minId = Constants.MAX_NUMBER_OF_PLAYERS;
                for (int j = 0; j < heroesInCell.size(); ++j) {
                    int id = heroesInCell.get(j).getId();
                    if (id < minId && id > lastMinId) {
                        minId = id;
                        currentHeroHelped = heroesInCell.get(j);
                    }
                }
                currentHeroHelped.acceptHelp(angel);
                lastMinId = currentHeroHelped.getId();
            }
        }
    }
    public static void heroesChoseStrategy(final ArrayList<Hero> heroes) {
        for (Hero hero : heroes) {
            hero.choseStrategy();
            hero.applyStrategy();
        }
    }
}
