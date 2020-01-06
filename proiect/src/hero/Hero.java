package hero;

import angel.Angel;
import common.Constants;
import gamemap.GameMap;
import observer.Observer;
import strategy.Strategy;

import java.util.ArrayList;

public abstract class Hero {
    protected String name;
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
    protected float angelModifier;
    protected float strategyBonus;
    protected Strategy playerStrategy;
    protected ArrayList<Observer> observers = new ArrayList<>();

    public abstract void isAttackedBy(Hero hero);

    public abstract void choseStrategy();
    public abstract void attack(Rogue rogue);
    public abstract void attack(Pyromancer pyromancer);
    public abstract void attack(Wizard wizard);
    public abstract void attack(Knight knight);
    public abstract void resetHealthPoints();
    public abstract void receiveHealth(int quantity);

    public abstract void acceptHelp(Angel angel);

    private void leaveCell() {
        GameMap gameMap = GameMap.getInstance();
        if (location.getLine() >= 0 && location.getRow() >= 0) {
            gameMap.heroLeaveCell(this, location);
        }
    }

    private void goToCell() {
        GameMap gameMap = GameMap.getInstance();
        if (location.getLine() >= 0 && location.getRow() >= 0) {
            gameMap.heroGoToCell(this, location);
        }
    }

    private void moveUp() {
        leaveCell();
        int newLine = location.getLine() - 1;
        location.setLine(newLine);
        goToCell();
    }

    private void moveDown() {
        leaveCell();
        int newLine = location.getLine() + 1;
        location.setLine(newLine);
        goToCell();
    }

    private void moveLeft() {
        leaveCell();
        int newRow = location.getRow() - 1;
        location.setRow(newRow);
        goToCell();
    }

    private void moveRight() {
        leaveCell();
        int newRow = location.getRow() + 1;
        location.setRow(newRow);
        goToCell();
    }

    private void setDeath() {
        healthPoints = 0;
    }

    public final void registerObserver(final Observer observer) {
        observers.add(observer);
    }

    public final void applyStrategy() {
        playerStrategy.modifyDmgBonus(this);
        playerStrategy.modifyHp(this);
    }

    public final void setStrategyBonus(final float strategyBonus) {
        this.strategyBonus += strategyBonus;
    }

    public final int getId() {
        return id;
    }

    public final void modifyAngelModifier(final float modifier) {
        angelModifier += modifier;
    }

    public final void newLevel() {
        experience = Constants.BASE_EXPERIENCE + (level + 1) * Constants.EXPERIENCE_BETWEEN_LEVELS;
        updateLevel();
    }

    public final void moveTo(final char nextLocation) {
        switch (nextLocation) {
            case 'U': moveUp(); break;
            case 'D': moveDown(); break;
            case 'L': moveLeft(); break;
            case 'R': moveRight(); break;
            case '_': break;
            default: break;
        }
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

    public final void revive(final int newHealthPoints, final Coordinates angelLocation) {
        this.healthPoints = newHealthPoints;
        notifyReviving();
    }

    public final void sufferDamage(final int damage) {
        healthPoints -= damage;
        if (healthPoints <= 0) {
            setDeath();
        }
    }

    public final void increaseExperience(final int quantity) {
        experience += quantity;
        updateLevel();
    }

    public final void updateLevel() {
        int newLevel = (experience - Constants.BASE_EXPERIENCE)
                / Constants.EXPERIENCE_BETWEEN_LEVELS;
        if (newLevel > level) {
            while (level < newLevel) {
                level++;
                notifyNewLevel();
            }
            resetHealthPoints();
        }
    }

    public final void killThemselves(final Hero hero) {
        notifyKilling(hero.getName());
    }

    public final void experienceGainedKillThemselves(final int killerLevel, final int opponentLevel) {
        int experienceGained = Constants.BASE_EXPERIENCE - (killerLevel - opponentLevel)
                * Constants.EXPERIENCE_GAINED_FOR_LEVEL;
        if (experienceGained < 0) {
            experienceGained = 0;
        }
        experience += experienceGained;
        if (experience > Constants.EXPERIENCE_FOR_FIRST_LEVEL) {
            updateLevel();
        }
    }

    public final void kill(final Hero hero) {
        notifyKilling(hero.getName());
        if (this.isAlive()) {
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
    }

    public final void notifyKilling(final String killed) {
        for (Observer observer : observers) {
            observer.update(name, killed);
        }
    }

    public final void notifyNewLevel() {
        for (Observer observer : observers) {
            observer.update(name, level);
        }
    }

    public final void notifyReviving() {
        for (Observer observer : observers) {
            observer.update(name);
        }
    }

    public final boolean isNowStunned() {
        if (roundsStunned == 0) {
            return false;
        }
        return true;
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

    public final float getLandModifier() {
        return landModifier;
    }

    public final String getName() {
        return name;
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
