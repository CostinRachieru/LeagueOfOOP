package hero;

import gamemap.Cell;
import gamemap.GameMap;

public abstract class Hero {
    protected int id;
    protected Coordinates location;
    protected int xp;
    protected int level;

    public abstract void isAttackedBy(Hero hero);
    public abstract void attack(Rogue rogue);
    public abstract void attack(Pyromancer pyromancer);
    public abstract void attack(Wizard wizard);
    public abstract void attack(Knight knight);

    public Coordinates getLocation() {
        return location;
    }

    protected void setLocation(int line, int row) {
        location.setLine(line);
        location.setRow(row);
    }

    public void printLocation() {
        System.out.println(location.getLine() + " : " + location.getRow());
        GameMap gameMap = GameMap.getInstance();
        Cell cell = gameMap.getCell(location);
        cell.printCellType();
        System.out.println();
    }

    private void leaveCell() {
        GameMap gameMap = GameMap.getInstance();
        gameMap.heroLeaveCell(this, location);
    }

    private void goToCell() {
        GameMap gameMap = GameMap.getInstance();
        gameMap.heroGoToCell(this, location);
    }

    private void moveUp() {
        int newLine = location.getLine() - 1;
        location.setLine(newLine);
    }

    private void moveDown() {
        int newLine = location.getLine() + 1;
        location.setLine(newLine);
    }

    private void moveLeft() {
        int newRow = location.getRow() - 1;
        location.setRow(newRow);
    }

    private void moveRight() {
        int newRow = location.getRow() + 1;
        location.setRow(newRow);
    }

    public void moveTo(char nextLocation) {
        this.leaveCell();
        switch (nextLocation) {
            case 'U': moveUp(); break;
            case 'D': moveDown(); break;
            case 'L': moveLeft(); break;
            case 'R': moveRight(); break;
            case '_': break;
        }
        goToCell();
    }

    public boolean sameAs(Hero hero) {
        if (this.id == hero.id) {
            return true;
        }
        return false;
    }

}