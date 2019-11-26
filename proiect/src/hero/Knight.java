package hero;

public final class Knight extends Hero {
    public Knight(int posX, int posY) {
        location = new Coordinates(posX, posY);
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

