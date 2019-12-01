package gamemap;

import common.Constants;
import hero.Hero;

import java.util.ArrayList;

public final class WoodsCell extends Cell {
    public WoodsCell() {
        heroesInCell = new ArrayList<Hero>();
        combatDone = false;
    }

    public boolean isCombat() {
        if (heroesInCell.size() == 2 && !combatDone) {
            Hero firstHero = heroesInCell.get(0);
            Hero secondHero = heroesInCell.get(1);
            if (firstHero.getType() == 'R') {
                firstHero.setLandModifier(Constants.WOODS_LAND_MODIFIER);
            } else {
                firstHero.setLandModifier(1);
            }
            if (secondHero.getType() == 'R') {
                secondHero.setLandModifier(Constants.WOODS_LAND_MODIFIER);
            } else {
                secondHero.setLandModifier(1);
            }
            combatDone = true;
            return true;
        } else {
            if (combatDone) {
                combatDone = false;
            }
        }
        return false;
    }
}
