package hero;

public abstract class Hero {
    Coordinates location;

    public abstract void isAttackedBy(Hero hero);
    public abstract void attack(Rogue rogue);
    public abstract void attack(Pyromancer pyromancer);
    public abstract void attack(Wizard wizard);
    public abstract void attack(Knight knight);

    public Coordinates getLocation() {
        return location;
    }

    public void setLocation(int posX, int posY) {
        location.setPosX(posX);
        location.setPosY(posY);
    }

    public void printLocation() {
        System.out.println(location.getPosX() + " : " + location.getPosY());
    }
}