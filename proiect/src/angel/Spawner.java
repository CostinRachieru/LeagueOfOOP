package angel;

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
    }

    public void help(final Knight hero) {
    }

    public void help(final Wizard hero) {
    }

    public void help(final Pyromancer hero) {
    }
}

