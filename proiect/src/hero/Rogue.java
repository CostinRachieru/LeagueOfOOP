package hero;

import angel.Angel;
import common.Constants;
import strategy.BasicRogue;
import strategy.LowHpRogue;
import strategy.SuperLowHpRogue;

public final class Rogue extends Hero {

    public Rogue(final int line, final int row, final int givenId) {
        location = new Coordinates(line, row);
        experience = 0;
        level = 0;
        id = givenId;
        healthPoints = Constants.ROGUE_BASE_HEALTHPOINTS;
        type = 'R';
        damageOverTime = 0;
        roundsLeftDmg = 0;
        criticalCount = 0;
        angelModifier = 0f;
        playerStrategy = new BasicRogue();
    }

    public void acceptHelp(final Angel angel) {
        angel.help(this);
    }

    public void resetHealthPoints() {
        healthPoints = Constants.ROGUE_BASE_HEALTHPOINTS + level
                * Constants.ROGUE_HEALTHPOINTS_PER_LEVEL;
    }

    protected float paralysis() {
        float modifier = landModifier;
        float damage = Constants.PARALYSIS_BASE_DAMAGE_OVER_TIME + (level
                * Constants.PARALYSIS_DAMAGE_PER_LEVEL);
        damage *= modifier;
        return damage;
    }

    protected float backstab() {
        float modifier = landModifier;
        float damage = Constants.BACKSTAB_BASE_DAMAGE + (level
                * Constants.BACKSTAB_DAMAGE_PER_LEVEL);
        damage *= modifier;
        return damage;
    }
    protected boolean isCritical() {
        if (criticalCount % Constants.BACKSTAB_THIRD_HIT == 0 && landModifier != 1) {
            return true;
        }
        return false;
    }

    @Override
    public void isAttackedBy(final Hero hero) {
        hero.attack(this);
    }

    @Override
    public void choseStrategy() {
        if (!this.isStunned()) {
            int maxPossibleHp = (Constants.ROGUE_BASE_HEALTHPOINTS + level
                    * Constants.ROGUE_HEALTHPOINTS_PER_LEVEL);
            float minHp = ((float) 1 / (float) Constants.ROGUE_MIN_LOW_HP_DENOMINATOR)
                    * maxPossibleHp;
            float maxHp = ((float) 1 / (float) Constants.ROGUE_MAX_LOW_HP_DENOMINATOR)
                    * maxPossibleHp;
            if ((float) healthPoints > minHp && (float) healthPoints < maxHp) {
                playerStrategy = new LowHpRogue();
            } else {
                if ((float) healthPoints < minHp) {
                    playerStrategy = new SuperLowHpRogue();
                } else {
                    playerStrategy = new BasicRogue();
                }
            }
        }
    }

    @Override
    public void receiveHealth(final int quantity) {
        healthPoints += quantity;
        int maxPossibleHp = Constants.ROGUE_BASE_HEALTHPOINTS + level
                * Constants.ROGUE_HEALTHPOINTS_PER_LEVEL;
        if (healthPoints > maxPossibleHp) {
            healthPoints = maxPossibleHp;
        }
    }

    @Override
    public void attack(final Rogue rogue) {
        float damage = backstab();
        if (isCritical()) {
            damage *= Constants.BACKSTAB_CRITICAL_HIT_MODIFIER;
        }
        int firstAbilityDmg = Math.round(damage
                * (Constants.RACE_MODIFIER_BACKSTAB_ROGUE_VS_ROGUE + angelModifier));
        int secondAbilityDmg = Math.round(paralysis()
                * (Constants.RACE_MODIFIER_PARALYSIS_ROGUE_VS_ROGUE + angelModifier));
        rogue.setDamageOverTime(secondAbilityDmg);
        if (landModifier != 1) {
            rogue.setRoundsLeftDmg(Constants.PARALYSIS_WOODS_ROUNDS_OVER_TIME);
            rogue.setRoundsStunned(Constants.PARALYSIS_WOODS_ROUNDS_OVER_TIME);
        } else {
            rogue.setRoundsLeftDmg(Constants.PARALYSIS_BASIC_ROUNDS_OVER_TIME);
            rogue.setRoundsStunned(Constants.PARALYSIS_BASIC_ROUNDS_OVER_TIME);
        }
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        rogue.sufferDamage(damageDealt);
    }

    @Override
    public void attack(final Pyromancer pyromancer) {
        float damage = backstab();
        if (isCritical()) {
            damage *= Constants.BACKSTAB_CRITICAL_HIT_MODIFIER;
        }
        int firstAbilityDmg = Math.round(damage
                * (Constants.RACE_MODIFIER_BACKSTAB_ROGUE_VS_PYROMANCER + angelModifier));
        int secondAbilityDmg = Math.round(paralysis()
                * (Constants.RACE_MODIFIER_PARALYSIS_ROGUE_VS_PYROMANCER + angelModifier));
        pyromancer.setDamageOverTime(secondAbilityDmg);
        if (landModifier != 1) {
            pyromancer.setRoundsLeftDmg(Constants.PARALYSIS_WOODS_ROUNDS_OVER_TIME);
            pyromancer.setRoundsStunned(Constants.PARALYSIS_WOODS_ROUNDS_OVER_TIME);
        } else {
            pyromancer.setRoundsLeftDmg(Constants.PARALYSIS_BASIC_ROUNDS_OVER_TIME);
            pyromancer.setRoundsStunned(Constants.PARALYSIS_BASIC_ROUNDS_OVER_TIME);
        }
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        pyromancer.sufferDamage(damageDealt);
    }

    @Override
    public void attack(final Wizard wizard) {
        float damage = backstab();
        if (isCritical()) {
            damage *= Constants.BACKSTAB_CRITICAL_HIT_MODIFIER;
        }
        int firstAbilityDmg = Math.round(damage
                * (Constants.RACE_MODIFIER_BACKSTAB_ROGUE_VS_WIZARD + angelModifier));
        int secondAbilityDmg = Math.round(paralysis()
                * (Constants.RACE_MODIFIER_PARALYSIS_ROGUE_VS_WIZARD + angelModifier));
        wizard.setDamageOverTime(secondAbilityDmg);
        if (landModifier != 1) {
            wizard.setRoundsLeftDmg(Constants.PARALYSIS_WOODS_ROUNDS_OVER_TIME);
            wizard.setRoundsStunned(Constants.PARALYSIS_WOODS_ROUNDS_OVER_TIME);
        } else {
            wizard.setRoundsLeftDmg(Constants.PARALYSIS_BASIC_ROUNDS_OVER_TIME);
            wizard.setRoundsStunned(Constants.PARALYSIS_BASIC_ROUNDS_OVER_TIME);
        }
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        wizard.sufferDamage(damageDealt);
    }

    @Override
    public void attack(final Knight knight) {
        float damage = backstab();
        if (isCritical()) {
            damage *= Constants.BACKSTAB_CRITICAL_HIT_MODIFIER;
        }
        int firstAbilityDmg = Math.round(damage
                * (Constants.RACE_MODIFIER_BACKSTAB_ROGUE_VS_KNIGHT + angelModifier));
        int secondAbilityDmg = Math.round(paralysis()
                * (Constants.RACE_MODIFIER_PARALYSIS_ROGUE_VS_KNIGHT + angelModifier));
        knight.setDamageOverTime(secondAbilityDmg);
        if (landModifier != 1) {
            knight.setRoundsLeftDmg(Constants.PARALYSIS_WOODS_ROUNDS_OVER_TIME);
            knight.setRoundsStunned(Constants.PARALYSIS_WOODS_ROUNDS_OVER_TIME);
        } else {
            knight.setRoundsLeftDmg(Constants.PARALYSIS_BASIC_ROUNDS_OVER_TIME);
            knight.setRoundsStunned(Constants.PARALYSIS_BASIC_ROUNDS_OVER_TIME);
        }
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        knight.sufferDamage(damageDealt);
    }
}

