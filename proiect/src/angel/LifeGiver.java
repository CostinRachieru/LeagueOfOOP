package angel;

import common.Constants;
import hero.Hero;
import hero.Coordinates;
import hero.Rogue;
import hero.Pyromancer;
import hero.Wizard;
import hero.Knight;

public final class LifeGiver extends Angel {
    public LifeGiver(final Coordinates location) {
        this.location = location;
    }

    public void giveHealth(final Hero hero, final int quantity) {
        hero.receiveHealth(quantity);
    }

    public void help(final Rogue hero) {
        giveHealth(hero, Constants.LIFEGIVER_GIVEN_HP_FOR_ROGUE);
    }

    public void help(final Knight hero) {
        giveHealth(hero, Constants.LIFEGIVER_GIVEN_HP_FOR_KNIGHT);
    }

    public void help(final Wizard hero) {
        giveHealth(hero, Constants.LIFEGIVER_GIVEN_HP_FOR_WIZARD);
    }

    public void help(final Pyromancer hero) {
        giveHealth(hero, Constants.LIFEGIVER_GIVEN_HP_FOR_PYROMANCER);
    }
}
