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
        if (heroesInCell.size() >= 2 && !combatDone) {
            int firstPosition = -1;
            int secondPosition = -1;
            for (int i = 0; i < heroesInCell.size(); ++i) {
                if (heroesInCell.get(i).isAlive()) {
                    if (firstPosition == -1) {
                        firstPosition = i;
                    } else {
                        secondPosition = i;
                        break;
                    }
                }
            }
            if (firstPosition != -1 && secondPosition != -1) {
                Hero firstHero = heroesInCell.get(firstPosition);
                Hero secondHero = heroesInCell.get(secondPosition);
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
            }
        } else {
            if (combatDone) {
                combatDone = false;
            }
        }
        return false;
    }
}
