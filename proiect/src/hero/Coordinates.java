package hero;

public class Coordinates {
    private int posX;
    private int posY;

    public Coordinates() {
        posX = -1;
        posY = -1;
    }
    public Coordinates(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
