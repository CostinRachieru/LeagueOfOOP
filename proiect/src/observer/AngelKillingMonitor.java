package observer;

import hero.Coordinates;
import main.GameInputLoader;

public class AngelKillingMonitor implements Observer {
    private GameInputLoader gameInputLoader;

    public AngelKillingMonitor(final GameInputLoader gameInputLoader) {
        this.gameInputLoader = gameInputLoader;
    }

    @Override
    public final void update(final String name, final Coordinates location) {
    }

    @Override
    public final void update(final String killer, final String killed) {
    }

    @Override
    public final void update(final String angelName, final String heroeName, final String action) {
    }

    @Override
    public final void update(final String name, final int level) {
    }

    @Override
    public final void update(final String name) {
    }

    @Override
    public final void updateAngelKill(final String killed) {
        gameInputLoader.write("Player " + killed + " was killed by an angel");
    }
}
