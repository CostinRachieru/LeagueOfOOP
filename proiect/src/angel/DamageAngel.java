package angel;

import common.Constants;
import hero.Coordinates;
import hero.Rogue;
import hero.Pyromancer;
import hero.Wizard;
import hero.Knight;

public final class DamageAngel extends Angel {
    public DamageAngel(final Coordinates location) {
        this.location = location;
        name = "DamageAngel";
        action = "helped";
    }

    public void help(final Rogue hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.DAMAGEANGEL_ROGUE_MODIFIER);
            notifyObserverHelp(hero.getName());
        }
    }

    public void help(final Knight hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.DAMAGEANGEL_KNIGHT_MODIFIER);
            notifyObserverHelp(hero.getName());
        }
    }

    public void help(final Wizard hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.DAMAGEANGEL_WIZARD_MODIFIER);
            notifyObserverHelp(hero.getName());
        }
    }

    public void help(final Pyromancer hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.DAMAGEANGEL_PYROMANCER_MODIFIER);
            notifyObserverHelp(hero.getName());
        }
    }
}
