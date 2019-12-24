package angel;

import hero.Coordinates;

public final class AngelFactory {
    private static AngelFactory instance = null;

    private AngelFactory() {
    }

    public static AngelFactory getInstance() {
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }

    public static Angel createAngel(final String type, Coordinates location) {
        switch (type) {
            case "DamageAngel": return new DamageAngel(location);
            case "DarkAngel": return new DarkAngel(location);
            case "Dracula": return new Dracula(location);
            case "GoodBoy": return new GoodBoy(location);
            case "LevelUpAngel": return new LevelUpAngel(location);
            case "LifeGiver": return new LifeGiver(location);
            case "SmallAngel": return new SmallAngel(location);
            case "Spawner": return new Spawner(location);
            case "TheDoomer": return new TheDoomer(location);
            case "XPAngel": return new XPAngel(location);
            default : return null;
        }
    }
}
