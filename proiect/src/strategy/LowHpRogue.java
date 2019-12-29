package strategy;

import common.Constants;
import hero.Hero;

public final class LowHpRogue implements Strategy {
    @Override
    public void modifyHp(final Hero hero) {
        float lostHp = ((float) 1 / (float) Constants.ROGUE_LOW_HP_STRATEGY_HP_LOST_DENOMINATOR)
                * (float) hero.getHealthPoints();
        hero.sufferDamage((int) lostHp);
    }

    @Override
    public void modifyDmgBonus(final Hero hero) {
        hero.setStrategyBonus(Constants.ROGUE_LOW_HP_STRATEGY_BONUS_MODIFIER);
    }
}
