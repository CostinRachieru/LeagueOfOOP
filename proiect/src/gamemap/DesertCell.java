package gamemap;

import common.Constants;
import hero.Hero;

import java.util.ArrayList;

public class DesertCell extends Cell {
    public DesertCell() {
        heroesInCell = new ArrayList<Hero>();
        combatDone = false;
    }

    /**
     * Method that checks if there will be a combat and also updates the land modifiers
     * for the heroes.
     */
    public final boolean isCombat() {
        if (heroesInCell.size() == 2 && !combatDone) {
            if (heroesInCell.get(0).isAlive() && heroesInCell.get(1).isAlive()) {
                Hero firstHero = heroesInCell.get(0);
                Hero secondHero = heroesInCell.get(1);
                if (firstHero.getType() == 'W') {
                    firstHero.setLandModifier(Constants.DESERT_LAND_MODIFIER);
                } else {
                    firstHero.setLandModifier(1);
                }
                if (secondHero.getType() == 'W') {
                    secondHero.setLandModifier(Constants.DESERT_LAND_MODIFIER);
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
