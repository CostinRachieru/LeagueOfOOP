package hero;

public final class HeroFactory {
    private static HeroFactory instance = null;

    private HeroFactory() { }

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    public Hero createHero(final String type) {
        switch (type) {
            case "Pyromancer": return new Pyromancer();
            case "Knight": return new Knight();
            case "Wizard": return new Wizard();
            case "Rogue": return new Rogue();
            default : return null;
        }
    }
}
