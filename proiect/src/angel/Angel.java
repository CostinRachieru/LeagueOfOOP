package angel;

import hero.*;

public abstract class Angel {
    protected Coordinates location;
    public abstract void help(Rogue rogue);
    public abstract void help(Knight knight);
    public abstract void help(Pyromancer pyromancer);
    public abstract void help(Wizard wizard);

    protected void giveHealth(final Hero hero, final int quantity) {
        if (hero.isAlive()) {
            hero.receiveHealth(quantity);
        }
    }

    public final Coordinates getLocation() {
        return location;
    }
}
