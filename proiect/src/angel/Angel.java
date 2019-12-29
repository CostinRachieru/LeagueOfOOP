package angel;

import hero.Coordinates;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;
import hero.Hero;


public abstract class Angel {
    protected Coordinates location;
    public abstract void help(Rogue rogue);
    public abstract void help(Knight knight);
    public abstract void help(Pyromancer pyromancer);
    public abstract void help(Wizard wizard);

    protected final void giveHealth(final Hero hero, final int quantity) {
        if (hero.isAlive()) {
            hero.receiveHealth(quantity);
        }
    }

    public final Coordinates getLocation() {
        return location;
    }
}
