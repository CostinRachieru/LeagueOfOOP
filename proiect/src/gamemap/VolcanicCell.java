package gamemap;

import common.Constants;
import hero.Hero;

import java.util.ArrayList;

public final class VolcanicCell extends Cell {
    public VolcanicCell() {
        heroesInCell = new ArrayList<Hero>();
        combatDone = false;
    }

    public boolean isCombat() {
        if (heroesInCell.size() == 2 && !combatDone) {
            Hero firstHero = heroesInCell.get(0);
            Hero secondHero = heroesInCell.get(1);
            if (firstHero.getType() == 'P') {
                firstHero.setLandModifier(Constants.VOLCANIC_LAND_MODIFIER);
            } else {
                firstHero.setLandModifier(1);
            }
            if (secondHero.getType() == 'P') {
                secondHero.setLandModifier(Constants.VOLCANIC_LAND_MODIFIER);
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
