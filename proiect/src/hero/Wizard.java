package hero;

import common.Constants;

public final class Wizard extends Hero {
    public Wizard(int line, int row, int givenId) {
        location = new Coordinates(line, row);
        experience = 0;
        level = 0;
        id = givenId;
        healthPoints = Constants.WIZARD_BASE_HEALTHPOINTS;
        type = 'W';
        damageOverTime = 0;
        roundsLeftDmg = 0;
    }

    public void resetHealthPoints() {
        healthPoints = Constants.WIZARD_BASE_HEALTHPOINTS + level * Constants.WIZARD_HEALTHPOINTS_PER_LEVEL;
    }

    @Override
    public void isAttackedBy(Hero hero) {
        hero.attack(this);
    }

    @Override
    public void attack(Rogue rogue) {
        System.out.println("W-R: Good day, rogue!");
    }

    @Override
    public void attack(Pyromancer pyromancer) {
        System.out.println("W-P: Yo, bro! Nice to see you!");
    }

    @Override
    public void attack(Wizard wizard) {
        System.out.println("W-W: Good evening!");
    }

    @Override
    public void attack(Knight knight) {
        System.out.println("W-K: Te am atacat fa");
    }
}

