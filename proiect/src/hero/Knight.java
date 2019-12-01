package hero;

import common.Constants;

public final class Knight extends Hero {
    public Knight(final int line, final int row, final int givenId) {
        location = new Coordinates(line, row);
        experience = 0;
        level = 0;
        id = givenId;
        healthPoints = Constants.KNIGHT_BASE_HEALTHPOINTS;
        type = 'K';
        damageOverTime = 0;
        roundsLeftDmg = 0;
    }

    protected float execute(final int maxOpponentHp, final int currentOpponentHp) {
        float modifier = landModifier;
        float hpLimit;
        if (level >= Constants.EXECUTE_LEVEL_LIMIT) {
            hpLimit = Constants.EXECUTE_MAX_HP_LIMIT;
        } else {
            float levelBonus = (float) level / Constants.GET_SECOND_DECIMAL;
            hpLimit = Constants.EXECUTE_BASE_HP_LIMIT + levelBonus;
        }
        if (currentOpponentHp <= hpLimit * maxOpponentHp) {
            return Constants.BIG_DMG_TO_KILL_EVERYTHING;
        }
        float damage = Constants.EXECUTE_BASE_DAMAGE + (level * Constants.EXECUTE_DAMAGE_PER_LEVEL);
        damage *= modifier;
        return  damage;
    }

    protected float slam() {
        float modifier = landModifier;
        float damage = Constants.SLAM_BASE_DAMAGE + (level * Constants.SLAM_DAMAGE_PER_LEVEL);
        damage *= modifier;
        return damage;
    }

    public void resetHealthPoints() {
        healthPoints = Constants.KNIGHT_BASE_HEALTHPOINTS + level
                * Constants.KNIGHT_HEALTHPOINTS_PER_LEVEL;
    }

    @Override
    public void isAttackedBy(final Hero hero) {
        hero.attack(this);
    }

    @Override
    public void attack(final Rogue rogue) {
        int maxOpponentHp = Constants.ROGUE_BASE_HEALTHPOINTS + rogue.getLevel()
                * Constants.ROGUE_HEALTHPOINTS_PER_LEVEL;
        int firstAbilityDmg;
        firstAbilityDmg = Math.round(execute(maxOpponentHp, rogue.getHealthPoints())
                * Constants.RACE_MODIFIER_EXECUTE_KNIGHT_VS_ROGUE);
        int secondAbilityDmg = Math.round(slam()
                * Constants.RACE_MODIFIER_SLAM_KNIGHT_VS_ROGUE);
        rogue.setRoundsStunned(1);
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        rogue.sufferDamage(damageDealt);
    }

    @Override
    public void attack(final Pyromancer pyromancer) {
        int maxOpponentHp = Constants.PYROMANCER_BASE_HEALTHPOINTS + pyromancer.getLevel()
                * Constants.PYROMANCER_HEALTHPOINTS_PER_LEVEL;
        int firstAbilityDmg;
        firstAbilityDmg = Math.round(execute(maxOpponentHp, pyromancer.getHealthPoints())
                * Constants.RACE_MODIFIER_EXECUTE_KNIGHT_VS_PYROMANCER);
        int secondAbilityDmg = Math.round(slam()
                * Constants.RACE_MODIFIER_SLAM_KNIGHT_VS_PYROMANCER);
        pyromancer.setRoundsStunned(1);
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        pyromancer.sufferDamage(damageDealt);
    }

    @Override
    public void attack(final Wizard wizard) {
        int maxOpponentHp = Constants.WIZARD_BASE_HEALTHPOINTS + wizard.getLevel()
                * Constants.WIZARD_HEALTHPOINTS_PER_LEVEL;
        int firstAbilityDmg;
        firstAbilityDmg = Math.round(execute(maxOpponentHp, wizard.getHealthPoints())
                * Constants.RACE_MODIFIER_EXECUTE_KNIGHT_VS_WIZARD);
        int secondAbilityDmg = Math.round(slam()
                * Constants.RACE_MODIFIER_SLAM_KNIGHT_VS_WIZARD);
        wizard.setRoundsStunned(1);
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        wizard.sufferDamage(damageDealt);
    }
    @Override
    public void attack(final Knight knight) {
        int maxOpponentHp = Constants.KNIGHT_BASE_HEALTHPOINTS + knight.getLevel()
                * Constants.KNIGHT_HEALTHPOINTS_PER_LEVEL;
        int firstAbilityDmg;
        firstAbilityDmg = Math.round(execute(maxOpponentHp, knight.getHealthPoints())
                * Constants.RACE_MODIFIER_EXECUTE_KNIGHT_VS_KNIGHT);
        int secondAbilityDmg = Math.round(slam()
                * Constants.RACE_MODIFIER_SLAM_KNIGHT_VS_KNIGHT);
        knight.setRoundsStunned(1);
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        knight.sufferDamage(damageDealt);
    }
}

