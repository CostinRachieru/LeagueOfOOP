package hero;

import common.Constants;
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
    protected int criticalCount;

    public abstract void isAttackedBy(Hero hero);
    public abstract void attack(Rogue rogue);
    public abstract void attack(Pyromancer pyromancer);
    public abstract void attack(Wizard wizard);
    public abstract void attack(Knight knight);
    public abstract void resetHealthPoints();

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

    public final void moveTo(final char nextLocation) {
        leaveCell();
        switch (nextLocation) {
            case 'U': moveUp(); break;
            case 'D': moveDown(); break;
            case 'L': moveLeft(); break;
            case 'R': moveRight(); break;
            case '_': break;
            default: break;
        }
        goToCell();
    }

    public final boolean sameAs(final Hero hero) {
        if (this.id == hero.id) {
            return true;
        }
        return false;
    }

    public final void sufferDamageOverTime() {
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

    public final void sufferDamage(final int damage) {
        healthPoints -= damage;
        if (healthPoints <= 0) {
            setDeath();
        }
    }

    public final void updateLevel() {
        int newlevel = (experience - Constants.BASE_EXPERIENCE)
                / Constants.EXPERIENCE_BETWEEN_LEVELS;
        if (newlevel > level) {
            level = newlevel;
            resetHealthPoints();
        }
    }

    public final void kill(final Hero hero) {
        int opponentLevel = hero.getLevel();
        int experienceGained = Constants.BASE_EXPERIENCE - (level - opponentLevel)
                * Constants.EXPERIENCE_GAINED_FOR_LEVEL;
        if (experienceGained < 0) {
            experienceGained = 0;
        }
        experience += experienceGained;
        if (experience > Constants.EXPERIENCE_FOR_FIRST_LEVEL) {
            updateLevel();
        }
    }

    public final boolean isStunned() {
        if (roundsStunned > 0) {
            roundsStunned--;
            return true;
        }
        return false;
    }

    public final boolean isAlive() {
        if (healthPoints > 0) {
            return true;
        }
        return false;
    }

    public final void increaseCriticalCount() {
        criticalCount++;
    }

    public final char getType() {
        return type;
    }

    public final void setLandModifier(final float landModifier) {
        this.landModifier = landModifier;
    }

    public final void setDamageOverTime(final int damage) {
        damageOverTime = damage;
    }

    public final void setRoundsLeftDmg(final int rounds) {
        roundsLeftDmg = rounds;
    }

    public final int getHealthPoints() {
        return  healthPoints;
    }

    public final int getLevel() {
        return level;
    }

    public final void setRoundsStunned(final int rounds) {
        roundsStunned = rounds;
    }

    public final int getExperience() {
        return experience;
    }

    public final Coordinates getLocation() {
        return location;
    }
}
