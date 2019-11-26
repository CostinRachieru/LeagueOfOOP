package hero;

public abstract class Hero {
    public abstract void isAttackedBy(Hero hero);
    public abstract void attack(Rogue rogue);
    public abstract void attack(Pyromancer pyromancer);
    public abstract void attack(Wizard wizard);
    public abstract void attack(Knight knight);
}