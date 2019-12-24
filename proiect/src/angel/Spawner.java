package angel;

import common.Constants;
import hero.Coordinates;
import hero.Rogue;
import hero.Pyromancer;
import hero.Wizard;
import hero.Knight;

public final class Spawner extends Angel {
    public Spawner(final Coordinates location) {
        this.location = location;
    }

    public void help(final Rogue hero) {
        if (!hero.isAlive()) {
            hero.revive(Constants.SPAWNER_NEW_HP_FOR_ROGUE, location);
        }
    }

    public void help(final Knight hero) {
        if (!hero.isAlive()) {
            hero.revive(Constants.SPAWNER_NEW_HP_FOR_ROGUE, location);
        }
    }

    public void help(final Wizard hero) {
        if (!hero.isAlive()) {
            hero.revive(Constants.SPAWNER_NEW_HP_FOR_ROGUE, location);
        }
    }

    public void help(final Pyromancer hero) {
        if (!hero.isAlive()) {
            hero.revive(Constants.SPAWNER_NEW_HP_FOR_ROGUE, location);
        }
    }
}

