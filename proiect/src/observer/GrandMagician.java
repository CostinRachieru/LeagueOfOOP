package observer;

import main.GameInputLoader;

public class GrandMagician {
    private Observer angelHelpingHeroes;
    private Observer angelKillingMonitor;
    private Observer angelSpawningMonitor;
    private Observer heroesLevelMonitor;
    private Observer killingMonitor;
    private Observer revivingMonitor;

    public GrandMagician(final GameInputLoader gameInputLoader) {
        angelHelpingHeroes = new AngelHelpingHeroes(gameInputLoader);
        angelKillingMonitor = new AngelKillingMonitor(gameInputLoader);
        angelSpawningMonitor = new AngelSpawningMonitor(gameInputLoader);
        heroesLevelMonitor = new HeroesLevelMonitor(gameInputLoader);
        killingMonitor = new KillingMonitor(gameInputLoader);
        revivingMonitor = new RevivingMonitor(gameInputLoader);
    }

    public final Observer getAngelHelpingHeroes() {
        return angelHelpingHeroes;
    }

    public final Observer getAngelKillingMonitor() {
        return angelKillingMonitor;
    }

    public final Observer getAngelSpawningMonitor() {
        return angelSpawningMonitor;
    }

    public final Observer getHeroesLevelMonitor() {
        return heroesLevelMonitor;
    }

    public final Observer getKillingMonitor() {
        return killingMonitor;
    }

    public final Observer getRevivingMonitor() {
        return revivingMonitor;
    }
}
