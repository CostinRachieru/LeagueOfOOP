package game;

import gamemap.GameMap;
import hero.Coordinates;
import hero.Hero;
import hero.HeroFactory;
import main.GameInput;

import java.util.ArrayList;

public final class GameEngine {
    private GameEngine() {
    }

    public static void initMap(GameInput gameInput) {
        GameMap map = GameMap.getInstance();
        map.initGameMap(gameInput.getMapHeight(), gameInput.getMapWidth(), gameInput.getMap());
    }

    public static ArrayList<Hero> initHeroes(GameInput gameInput) {
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

    public static void moveHeroes(int round, ArrayList<String> moves, ArrayList<Hero> heroes) {
        String movesThisRound = moves.get(round);
        int whichHero = 0;
        /**
         * Moves every player to the desired location.
         */
        for (Hero hero : heroes) {
            hero.sufferDamageOverTime();
            char nextLocation = movesThisRound.charAt(whichHero);
            if (hero.isAlive()) {
                if (!hero.isStunned()) {
                    hero.moveTo(nextLocation);
                }
            }
            whichHero++;
        }
    }

    public static void doCombats(ArrayList<Hero> heroes) {
        GameMap map = GameMap.getInstance();
        for (Hero hero : heroes) {
            System.out.println("Check: ID:" + hero.getId() + " - " + hero.getHealthPoints());
            if (hero.isAlive()) {
                hero.printLocation();
            }
            System.out.println();
            if (hero.isAlive()) {
                Coordinates location = hero.getLocation();
                if (map.isCombat(location)) {
                    ArrayList<Hero> heroesToFight = map.getHeroesInCell(location);
                    Hero firstHero = heroesToFight.get(0); // P
                    Hero secondHero = heroesToFight.get(1); // K
                    System.out.println(firstHero.getId() + ": " + firstHero.getHealthPoints());
                    System.out.println(secondHero.getId() + ": " + secondHero.getHealthPoints());
                    secondHero.isAttackedBy(firstHero);
                    firstHero.isAttackedBy(secondHero);
                    System.out.println(firstHero.getId() + ": HEALTH " + firstHero.getHealthPoints());
                    System.out.println(secondHero.getId() + ": HEALTH " + secondHero.getHealthPoints());
                    if (firstHero.isAlive() && !secondHero.isAlive()) {
                        firstHero.kill(secondHero);
                    }
                    if (secondHero.isAlive() && !firstHero.isAlive()) {
                        secondHero.kill(firstHero);
                    }
                }
            }
        }
    }
}
