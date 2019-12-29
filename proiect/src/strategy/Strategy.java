package strategy;

import hero.Hero;

public interface Strategy {
    void modifyHp(Hero hero);
    void modifyDmgBonus(Hero hero);
}
