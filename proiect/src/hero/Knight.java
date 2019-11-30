package hero;

import common.Constants;

public final class Knight extends Hero {
    public Knight(int line, int row, int givenId) {
        location = new Coordinates(line, row);
        experience = 0;
        level = 0;
        id = givenId;
        healthPoints = Constants.KNIGHT_BASE_HEALTHPOINTS;
        type = 'K';
        damageOverTime = 0;
        roundsLeftDmg = 0;
    }

    public void resetHealthPoints() {
        healthPoints = Constants.KNIGHT_BASE_HEALTHPOINTS;
    }

    @Override
    public void isAttackedBy(Hero hero) {
        hero.attack(this);
    }

    @Override
    public void attack(Rogue rogue) {
        System.out.println("K-R: Good day, rogue!");
    }

    @Override
    public void attack(Pyromancer pyromancer) {
        System.out.println("K-P: Yo, bro! Nice to see you!");
    }

    @Override
    public void attack(Wizard wizard) {
        System.out.println("K-W: Good evening!");
    }
    
    @Override
    public void attack(Knight knight) {
        System.out.println("K-K: Te am atacat fa");
    }
}

