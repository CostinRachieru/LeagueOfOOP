package angel;

import common.Constants;
import hero.Coordinates;
import hero.Rogue;
import hero.Pyromancer;
import hero.Wizard;
import hero.Knight;

public final class LifeGiver extends Angel {
    public LifeGiver(final Coordinates location) {
        this.location = location;
    }

    public void help(final Rogue hero) {
        if (hero.isAlive()) {
            giveHealth(hero, Constants.LIFEGIVER_GIVEN_HP_FOR_ROGUE);
        }
    }

    public void help(final Knight hero) {
        if (hero.isAlive()) {
            giveHealth(hero, Constants.LIFEGIVER_GIVEN_HP_FOR_KNIGHT);
        }
    }

    public void help(final Wizard hero) {
        if (hero.isAlive()) {
            giveHealth(hero, Constants.LIFEGIVER_GIVEN_HP_FOR_WIZARD);
        }
    }

    public void help(final Pyromancer hero) {
        if (hero.isAlive()) {
            giveHealth(hero, Constants.LIFEGIVER_GIVEN_HP_FOR_PYROMANCER);
        }
    }
}
