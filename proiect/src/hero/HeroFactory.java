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

    public Hero createHero(final String type, int posX, int posY) {
        switch (type) {
            case "P": return new Pyromancer(posX, posY);
            case "K": return new Knight(posX, posY);
            case "W": return new Wizard(posX, posY);
            case "R": return new Rogue(posX, posY);
            default : return null;
        }
    }
}
