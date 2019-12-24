package angel;

import common.Constants;
import hero.Coordinates;
import hero.Rogue;
import hero.Pyromancer;
import hero.Wizard;
import hero.Knight;

public final class Dracula extends Angel {
    public Dracula(final Coordinates location) {
        this.location = location;
    }

    public void help(final Rogue hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.DRACULA_ROGUE_MODIFIER);
            hero.sufferDamage(Constants.DRACULA_TAKEN_HP_FOR_ROGUE);
        }
    }

    public void help(final Knight hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.DRACULA_KNIGHT_MODIFIER);
            hero.sufferDamage(Constants.DRACULA_TAKEN_HP_FOR_KNIGHT);
        }
    }

    public void help(final Wizard hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.DRACULA_WIZARD_MODIFIER);
            hero.sufferDamage(Constants.DRACULA_TAKEN_HP_FOR_WIZARD);
        }
    }

    public void help(final Pyromancer hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.DRACULA_PYROMANCER_MODIFIER);
            hero.sufferDamage(Constants.DRACULA_TAKEN_HP_FOR_PYROMANCER);
        }
    }
}
