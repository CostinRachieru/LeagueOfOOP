package observer;

import hero.Coordinates;
import main.GameInputLoader;

public class HeroesLevelMonitor implements Observer {
    private GameInputLoader gameInputLoader;

    public HeroesLevelMonitor(final GameInputLoader gameInputLoader) {
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
        gameInputLoader.write(name + " reached level " + level);
    }

    @Override
    public final void update(final String name) {
    }

    @Override
    public final void updateAngelKill(final String killed) {
    }
}
