package angel;

import common.Constants;
import hero.Coordinates;
import hero.Rogue;
import hero.Pyromancer;
import hero.Wizard;
import hero.Knight;

public final class DarkAngel extends Angel {
    public DarkAngel(final Coordinates location) {
        this.location = location;
        name = "DarkAngel";
        action = "hit";
    }

    public void help(final Rogue hero) {
        if (hero.isAlive()) {
            hero.sufferDamage(Constants.DARKANGEL_TAKEN_HEP_FOR_ROGUE);
            notifyObserverHelp(hero.getName());
            if (!hero.isAlive()) {
                notifyObserverKilling(hero.getName());
            }
        }
    }

    public void help(final Knight hero) {
        if (hero.isAlive()) {
            hero.sufferDamage(Constants.DARKANGEL_TAKEN_HEP_FOR_KNIGHT);
            notifyObserverHelp(hero.getName());
            if (!hero.isAlive()) {
                notifyObserverKilling(hero.getName());
            }
        }
    }

    public void help(final Wizard hero) {
        if (hero.isAlive()) {
            hero.sufferDamage(Constants.DARKANGEL_TAKEN_HEP_FOR_WIZARD);
            notifyObserverHelp(hero.getName());
            if (!hero.isAlive()) {
                notifyObserverKilling(hero.getName());
            }
        }
    }

    public void help(final Pyromancer hero) {
        if (hero.isAlive()) {
            hero.sufferDamage(Constants.DARKANGEL_TAKEN_HEP_FOR_PYROMANCER);
            notifyObserverHelp(hero.getName());
            if (!hero.isAlive()) {
                notifyObserverKilling(hero.getName());
            }
        }
    }
}
