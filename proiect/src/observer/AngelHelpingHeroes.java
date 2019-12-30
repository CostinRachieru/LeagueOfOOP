package observer;

import hero.Coordinates;
import main.GameInputLoader;

public class AngelHelpingHeroes implements Observer {
    private GameInputLoader gameInputLoader;

    public AngelHelpingHeroes(final GameInputLoader gameInputLoader) {
        this.gameInputLoader = gameInputLoader;
    }

    @Override
    public void update(final String name, final Coordinates location) {
    }

    @Override
    public void update(final String killer, final String killed) {
    }

    @Override
    public void update(final String angelName, final String heroName, final String action) {
        gameInputLoader.write(angelName + " " + action + " " + heroName);
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
