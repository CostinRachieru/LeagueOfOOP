package hero;

public final class Wizard extends Hero {
    public Wizard(int line, int row, int givenId) {
        location = new Coordinates(line, row);
        xp = 0;
        level = 0;
        id = givenId;
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

