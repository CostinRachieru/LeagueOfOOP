package strategy;

import common.Constants;
import hero.Hero;

public final class LowHpPyromancer implements Strategy {
    @Override
    public void modifyHp(final Hero hero) {
        float lostHp = ((float) 1
                / (float) Constants.PYROMANCER_LOW_HP_STRATEGY_HP_LOST_DENOMINATOR)
                * (float) hero.getHealthPoints();
        hero.sufferDamage((int) lostHp);
    }

    @Override
    public void modifyDmgBonus(final Hero hero) {
        hero.setStrategyBonus(Constants.PYROMANCER_LOW_HP_STRATEGY_BONUS_MODIFIER);
    }
}
