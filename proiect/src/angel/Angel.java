package angel;

import hero.Coordinates;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;
import hero.Hero;
import observer.Observer;

import java.util.ArrayList;


public abstract class Angel {
    protected Coordinates location;
    protected String name;
    protected ArrayList<Observer> observers = new ArrayList<>();
    protected String action;

    public abstract void help(Rogue rogue);
    public abstract void help(Knight knight);
    public abstract void help(Pyromancer pyromancer);
    public abstract void help(Wizard wizard);

    protected final void giveHealth(final Hero hero, final int quantity) {
        if (hero.isAlive()) {
            hero.receiveHealth(quantity);
        }
    }

    public final void notifyObserverSpawn() {
        for (Observer observer : observers) {
            observer.update(name, location);
        }
    }

    public final void notifyObserverHelp(final String heroName) {
        for (Observer observer : observers) {
            observer.update(name, heroName, action);
        }
    }

    public final void notifyObserverKilling(final String killed) {
        for (Observer observer : observers) {
            observer.updateAngelKill(killed);
        }
    }
    public final void registerObserver(final Observer observer) {
        observers.add(observer);
    }

    public final Coordinates getLocation() {
        return location;
    }
}
