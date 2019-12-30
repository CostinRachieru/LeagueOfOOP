package observer;

import hero.Coordinates;
import main.GameInputLoader;

public class AngelSpawningMonitor implements Observer {

    private GameInputLoader gameInputLoader;

    public AngelSpawningMonitor(final GameInputLoader gameInputLoader) {
        this.gameInputLoader = gameInputLoader;
    }

    @Override
    public final void update(final String name, final Coordinates location) {
        gameInputLoader.write("Angel " + name + " was spawned at "
                + location.getLine() + " " + location.getRow());
    }

    @Override
    public void update(final String killer, final String killed) {
    }

    @Override
    public void update(final String angelName, final String heroeName, final String action) {
    }

    @Override
    public void update(final String name, final int level) {
    }

    @Override
    public void update(final String name) {
    }

    @Override
    public void updateAngelKill(final String killed) {
    }
}
