package hero;

import common.Constants;

public final class Knight extends Hero {
    public Knight(int line, int row, int givenId) {
        location = new Coordinates(line, row);
        experience = 0;
        level = 0;
        id = givenId;
        healthPoints = Constants.KNIGHT_BASE_HEALTHPOINTS;
        type = 'K';
        damageOverTime = 0;
        roundsLeftDmg = 0;
    }

    private float execute() {
        float modifier = landModifier;
        float damage = Constants.EXECUTE_BASE_DAMAGE + (level * Constants.EXECUTE_DAMAGE_PER_LEVEL);
        damage *= modifier;
        return  damage;
    }

    private float slam() {
        float modifier = landModifier;
        float damage = Constants.SLAM_BASE_DAMAGE + (level * Constants.SLAM_DAMAGE_PER_LEVEL);
        damage *= modifier;
        return damage;
    }

    public void resetHealthPoints() {
        healthPoints = Constants.KNIGHT_BASE_HEALTHPOINTS + level * Constants.KNIGHT_HEALTHPOINTS_PER_LEVEL;
    }

    @Override
    public void isAttackedBy(Hero hero) {
        hero.attack(this);
    }

    @Override
    public void attack(Rogue rogue) {
        System.out.println("Knight vs. Rogue");
        float hpLimit;
        if (level >= 20) {
            hpLimit = 0.4f;
        } else {
            float levelBonus = (float)level / 100;
            hpLimit = Constants.EXECUTE_BASE_HP_LIMIT + levelBonus;
        }
        int maxOpponentHp = Constants.KNIGHT_BASE_HEALTHPOINTS + rogue.getLevel() *
                Constants.KNIGHT_HEALTHPOINTS_PER_LEVEL;
        int firstAbilityDmg;
        if (rogue.getHealthPoints() <= hpLimit * maxOpponentHp) {
            firstAbilityDmg = rogue.getHealthPoints();
        } else {
            firstAbilityDmg = Math.round(execute() *
                    Constants.RACE_MODIFIER_EXECUTE_KNIGHT_VS_KNIGHT);
        }
        System.out.println("EXECUTE: " + firstAbilityDmg);

        int secondAbilityDmg = Math.round(slam() *
                Constants.RACE_MODIFIER_SLAM_KNIGHT_VS_KNIGHT);
        System.out.println("SLAM: " + secondAbilityDmg);
        rogue.setRoundsStunned(1);
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        rogue.sufferDamage(damageDealt);
    }

    @Override
    public void attack(Pyromancer pyromancer) {
        System.out.println("Knight vs. Pyromancer");
        float hpLimit;
        if (level >= 20) {
            hpLimit = 0.4f;
        } else {
            float levelBonus = (float)level / 100;
            hpLimit = Constants.EXECUTE_BASE_HP_LIMIT + levelBonus;
        }
//        System.out.println("HPLIMIT = " + hpLimit);
        int maxOpponentHp = Constants.KNIGHT_BASE_HEALTHPOINTS + pyromancer.getLevel() *
                Constants.KNIGHT_HEALTHPOINTS_PER_LEVEL;
        int firstAbilityDmg;
        if (pyromancer.getHealthPoints() <= hpLimit * maxOpponentHp) {
            firstAbilityDmg = pyromancer.getHealthPoints();
        } else {
            firstAbilityDmg = Math.round(execute() *
                    Constants.RACE_MODIFIER_EXECUTE_KNIGHT_VS_KNIGHT);
        }
        System.out.println("EXECUTE: " + firstAbilityDmg);

        int secondAbilityDmg = Math.round(slam() *
                Constants.RACE_MODIFIER_SLAM_KNIGHT_VS_KNIGHT);
        System.out.println("SLAM: " + secondAbilityDmg);
        pyromancer.setRoundsStunned(1);
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        pyromancer.sufferDamage(damageDealt);
    }

    @Override
    public void attack(Wizard wizard) {
        System.out.println("Knight vs. Wizard");
        float hpLimit;
        if (level >= 20) {
            hpLimit = 0.4f;
        } else {
            float levelBonus = (float)level / 100;
            hpLimit = Constants.EXECUTE_BASE_HP_LIMIT + levelBonus;
        }
//        System.out.println("HPLIMIT = " + hpLimit);
        int maxOpponentHp = Constants.KNIGHT_BASE_HEALTHPOINTS + wizard.getLevel() *
                Constants.KNIGHT_HEALTHPOINTS_PER_LEVEL;
        int firstAbilityDmg;
        if (wizard.getHealthPoints() <= hpLimit * maxOpponentHp) {
            firstAbilityDmg = wizard.getHealthPoints();
        } else {
            firstAbilityDmg = Math.round(execute() *
                    Constants.RACE_MODIFIER_EXECUTE_KNIGHT_VS_KNIGHT);
        }
        System.out.println("EXECUTE: " + firstAbilityDmg);

        int secondAbilityDmg = Math.round(slam() *
                Constants.RACE_MODIFIER_SLAM_KNIGHT_VS_KNIGHT);
        System.out.println("SLAM: " + secondAbilityDmg);
        wizard.setRoundsStunned(1);
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        wizard.sufferDamage(damageDealt);
    }
    
    @Override
    public void attack(Knight knight) {
        System.out.println("Knight vs. Knight");
        float hpLimit;
        if (level >= 20) {
            hpLimit = 0.4f;
        } else {
            float levelBonus = (float)level / 100;
            hpLimit = Constants.EXECUTE_BASE_HP_LIMIT + levelBonus;
        }
//        System.out.println("HPLIMIT = " + hpLimit);
        int maxOpponentHp = Constants.KNIGHT_BASE_HEALTHPOINTS + knight.getLevel() *
                Constants.KNIGHT_HEALTHPOINTS_PER_LEVEL;
        int firstAbilityDmg;
        if (knight.getHealthPoints() <= hpLimit * maxOpponentHp) {
            firstAbilityDmg = knight.getHealthPoints();
        } else {
            firstAbilityDmg = Math.round(execute() *
                    Constants.RACE_MODIFIER_EXECUTE_KNIGHT_VS_KNIGHT);
        }
        System.out.println("EXECUTE: " + firstAbilityDmg);

        int secondAbilityDmg = Math.round(slam() *
                Constants.RACE_MODIFIER_SLAM_KNIGHT_VS_KNIGHT);
        System.out.println("SLAM: " + secondAbilityDmg);
        knight.setRoundsStunned(1);
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        knight.sufferDamage(damageDealt);
    }
}

