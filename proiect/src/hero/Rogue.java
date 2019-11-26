package hero;

public final class Rogue extends Hero{
    @Override
    public void isAttackedBy(Hero hero) {
        hero.attack(this);
    }

    @Override
    public void attack(Rogue rogue) {
        System.out.println("R-R: Good day, rogue!");
    }

    @Override
    public void attack(Pyromancer pyromancer) {
        System.out.println("R-P: Yo, bro! Nice to see you!");
    }

    @Override
    public void attack(Wizard wizard) {
        System.out.println("R-W: Good evening!");
    }

    @Override
    public void attack(Knight knight) {
        System.out.println("R-K: Te am atacat fa");
    }
}
