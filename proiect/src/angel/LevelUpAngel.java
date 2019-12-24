package angel;

import common.Constants;
import hero.Coordinates;
import hero.Rogue;
import hero.Pyromancer;
import hero.Wizard;
import hero.Knight;

public final class LevelUpAngel extends Angel {
    public LevelUpAngel(final Coordinates location) {
        this.location = location;
    }

    public void help(final Rogue hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.LEVELUPANGEL_ROGUE_MODIFIER);
            hero.newLevel();
        }
    }

    public void help(final Knight hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.LEVELUPANGEL_KNIGHT_MODIFIER);
            hero.newLevel();
        }
    }

    public void help(final Wizard hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.LEVELUPANGEL_WIZARD_MODIFIER);
            hero.newLevel();
        }
    }

    public void help(final Pyromancer hero) {
        if (hero.isAlive()) {
            hero.modifyAngelModifier(Constants.LEVELUPANGEL_PYROMANCER_MODIFIER);
            hero.newLevel();
        }
    }
}
