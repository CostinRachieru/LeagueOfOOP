package hero;

import common.Constants;
import gamemap.Cell;
import gamemap.GameMap;

public abstract class Hero {
    protected int id;
    protected Coordinates location;
    protected int experience;
    protected int level;
    protected int healthPoints;
    protected char type;
    protected float landModifier;
    protected int damageOverTime;
    protected int roundsLeftDmg;
    protected int roundsStunned;

    public abstract void isAttackedBy(Hero hero);
    public abstract void attack(Rogue rogue);
    public abstract void attack(Pyromancer pyromancer);
    public abstract void attack(Wizard wizard);
    public abstract void attack(Knight knight);
    public abstract void resetHealthPoints();

    public Coordinates getLocation() {
        return location;
    }

    protected void setLocation(int line, int row) {
        location.setLine(line);
        location.setRow(row);
    }

    public void printLocation() {
        System.out.println(location.getLine() + " : " + location.getRow());
        System.out.println("ID: " + id);
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
        leaveCell();
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

    public char getType() {
        return type;
    }

    public void setLandModifier(float landModifier) {
        this.landModifier = landModifier;
    }

    public float getLandModifier() {
        return landModifier;
    }

    public void setDamageOverTime(int damage) {
        damageOverTime = damage;
    }

    public void setRoundsLeftDmg(int rounds) {
        roundsLeftDmg = rounds;
    }

    public void sufferDamageOverTime() {
        if (roundsLeftDmg > 0) {
            roundsLeftDmg--;
            sufferDamage(damageOverTime);
        }
    }

    private void setDeath() {
        healthPoints = 0;
        damageOverTime = 0;
        roundsLeftDmg = 0;
        leaveCell();
        location.setRow(-1);
        location.setLine(-1);
    }

    public void sufferDamage(int damage) {
        healthPoints -= damage;
        if (healthPoints <= 0) {
            setDeath();
        }
    }

    public void updateLevel() {
        int newlevel = (experience - Constants.BASE_EXPERIENCE) / Constants.EXPERIENCE_BETWEEN_LEVELS;
        if (newlevel > level) {
            level = newlevel;
            resetHealthPoints();
        }
        System.out.println(id + ": LEVEL " + level);
    }

    public void kill(Hero hero) {
        int opponentLevel = hero.getLevel();
        int experienceGained = 200 - (level - opponentLevel) * 40;
        if (experienceGained < 0) {
            experienceGained = 0;
        }
        experience += experienceGained;
        if (experience > 250) {
            updateLevel();
        }
    }

    public boolean isStunned() {
        if (roundsStunned > 0) {
            roundsStunned--;
            return true;
        }
        return false;
    }

    public boolean isAlive() {
        if (healthPoints > 0) {
            return true;
        }
        return false;
    }

    public int getHealthPoints() {
        return  healthPoints;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void setRoundsStunned(int rounds) {
        roundsStunned = rounds;
    }
}