package strategy;

import common.Constants;
import hero.Hero;

public final class SuperLowHpWizard implements Strategy {
    @Override
    public void modifyHp(final Hero hero) {
        float gainedHp = ((float) 1
                / (float) Constants.WIZARD_SUPER_LOW_HP_STRATEGY_HP_GAINED_DENOMINATOR)
                * (float) hero.getHealthPoints();
        hero.receiveHealth((int) gainedHp);
    }

    @Override
    public void modifyDmgBonus(final Hero hero) {
        hero.setStrategyBonus(Constants.WIZARD_SUPER_LOW_HP_STRATEGY_DECREASED_MODIFIER);
    }
}
