package angel;

import common.Constants;
import hero.Coordinates;
import hero.Rogue;
import hero.Pyromancer;
import hero.Wizard;
import hero.Knight;

public final class GoodBoy extends Angel {
    public GoodBoy(final Coordinates location) {
        this.location = location;
        name = "GoodBoy";
        action = "helped";
    }

    public void help(final Rogue hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.GOODBOY_ROGUE_MODIFIER);
            giveHealth(hero, Constants.GOODBOY_GIVEN_HP_FOR_ROGUE);
            notifyObserverHelp(hero.getName());
        }
    }

    public void help(final Knight hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.GOODBOY_KNIGHT_MODIFIER);
            giveHealth(hero, Constants.GOODBOY_GIVEN_HP_FOR_KNIGHT);
            notifyObserverHelp(hero.getName());
        }
    }

    public void help(final Wizard hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.GOODBOY_WIZARD_MODIFIER);
            giveHealth(hero, Constants.GOODBOY_GIVEN_HP_FOR_WIZARD);
            notifyObserverHelp(hero.getName());
        }
    }

    public void help(final Pyromancer hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.GOODBOY_PYROMANCER_MODIFIER);
            giveHealth(hero, Constants.GOODBOY_GIVEN_HP_FOR_PYROMANCER);
            notifyObserverHelp(hero.getName());
        }
    }
}
