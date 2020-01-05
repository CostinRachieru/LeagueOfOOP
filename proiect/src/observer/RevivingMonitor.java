package observer;

import hero.Coordinates;
import main.GameInputLoader;

public class RevivingMonitor implements Observer {
    private GameInputLoader gameInputLoader;

    public RevivingMonitor(final GameInputLoader gameInputLoader) {
        this.gameInputLoader = gameInputLoader;
    }

    @Override
    public final void update(final String name, final Coordinates location) {
    }

    @Override
    public final void update(final String killer, final String killed) {
    }

    @Override
    public void update(final String angelName, final String heroeName, final String action) {
    }

    @Override
    public void update(final String name, final int level) {
    }

    @Override
    public final void update(final String name) {
        gameInputLoader.write("Player " + name + " was brought to life by an angel");
    }

    @Override
    public void updateAngelKill(final String killed) {
    }
}
