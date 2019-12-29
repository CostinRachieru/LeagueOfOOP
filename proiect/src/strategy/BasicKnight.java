package strategy;

import hero.Hero;

public final class BasicKnight implements Strategy {
    @Override
    public void modifyHp(final Hero hero) {
    }

    @Override
    public void modifyDmgBonus(final Hero hero) {
        hero.setStrategyBonus(0f);
    }
}
