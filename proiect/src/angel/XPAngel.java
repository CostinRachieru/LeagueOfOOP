package angel;

import common.Constants;
import hero.Coordinates;
import hero.Rogue;
import hero.Pyromancer;
import hero.Wizard;
import hero.Knight;

public final class XPAngel extends Angel {
    public XPAngel(final Coordinates location) {
        this.location = location;
        name = "XPAngel";
        action = "helped";
    }

    public void help(final Rogue hero) {
        if (hero.isAlive()) {
            hero.increaseExperience(Constants.XPANGEL_GIVEN_XP_FOR_ROGUE);
            notifyObserverHelp(hero.getName());
        }
    }

    public void help(final Knight hero) {
        if (hero.isAlive()) {
            hero.increaseExperience(Constants.XPANGEL_GIVEN_XP_FOR_KNIGHT);
            notifyObserverHelp(hero.getName());
        }
    }

    public void help(final Wizard hero) {
        if (hero.isAlive()) {
            hero.increaseExperience(Constants.XPANGEL_GIVEN_XP_FOR_WIZARD);
            notifyObserverHelp(hero.getName());
        }
    }

    public void help(final Pyromancer hero) {
        if (hero.isAlive()) {
            hero.increaseExperience(Constants.XPANGEL_GIVEN_XP_FOR_PYROMANCER);
            notifyObserverHelp(hero.getName());
        }
    }
}
