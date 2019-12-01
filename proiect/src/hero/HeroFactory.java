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

    public Hero createHero(final String type, final int line, final int row, final int id) {
        switch (type) {
            case "P": return new Pyromancer(line, row, id);
            case "K": return new Knight(line, row, id);
            case "W": return new Wizard(line, row, id);
            case "R": return new Rogue(line, row, id);
            default : return null;
        }
    }
}
