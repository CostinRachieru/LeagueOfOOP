package angel;

import hero.Rogue;
import hero.Knight;
import hero.Pyromancer;
import hero.Wizard;
import hero.Coordinates;

public abstract class Angel {
    protected Coordinates location;
    public abstract void help(Rogue rogue);
    public abstract void help(Knight knight);
    public abstract void help(Pyromancer pyromancer);
    public abstract void help(Wizard wizard);

    public final Coordinates getLocation() {
        return location;
    }
}
