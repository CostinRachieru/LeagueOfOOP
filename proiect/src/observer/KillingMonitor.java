package observer;

import hero.Coordinates;
import main.GameInputLoader;

public class KillingMonitor implements Observer {

    private GameInputLoader gameInputLoader;

    public KillingMonitor(final GameInputLoader gameInputLoader) {
        this.gameInputLoader = gameInputLoader;
    }

    @Override
    public final void update(final String name, final Coordinates location) {
    }

    @Override
    public final void update(final String killer, final String killed) {
     gameInputLoader.write("Player " + killed + " was killed by " + killer);
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
