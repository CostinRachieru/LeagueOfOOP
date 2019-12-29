package strategy;

import hero.Hero;

public interface KnightStrategy {
    void modifyHp(Hero hero);
    void modifyDmgBonus(Hero hero);
}
