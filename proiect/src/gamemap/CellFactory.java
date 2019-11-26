package gamemap;

public class CellFactory {
    private static CellFactory instance = null;

    private CellFactory() { }

    public static CellFactory getInstance() {
        if (instance == null) {
            instance = new CellFactory();
        }
        return instance;
    }

    public Cell createCell(final char type) {
        switch (type) {
            case 'W': return new WoodsCell();
            case 'V': return new VolcanicCell();
            case 'D': return new DesertCell();
            case 'L': return new LandCell();
            default : return null;
        }
    }
}
