package angel;

import hero.Coordinates;
import hero.Rogue;
import hero.Pyromancer;
import hero.Wizard;
import hero.Knight;

public final class TheDoomer extends Angel {
    public TheDoomer(final Coordinates location) {
        this.location = location;
        name = "TheDoomer";
        action = "hit";
    }

    public void help(final Rogue hero) {
        if (hero.isAlive()) {
            hero.sufferDamage(hero.getHealthPoints());
            notifyObserverHelp(hero.getName());
            notifyObserverKilling(hero.getName());
        }
    }

    public void help(final Knight hero) {
        if (hero.isAlive()) {
            hero.sufferDamage(hero.getHealthPoints());
            notifyObserverHelp(hero.getName());
            notifyObserverKilling(hero.getName());
        }
    }

    public void help(final Wizard hero) {
        if (hero.isAlive()) {
            hero.sufferDamage(hero.getHealthPoints());
            notifyObserverHelp(hero.getName());
            notifyObserverKilling(hero.getName());
        }
    }

    public void help(final Pyromancer hero) {
        if (hero.isAlive()) {
            hero.sufferDamage(hero.getHealthPoints());
            notifyObserverHelp(hero.getName());
            notifyObserverKilling(hero.getName());
        }
    }
}
