package hero;

import angel.Angel;
import common.Constants;
import strategy.BasicPyromancer;
import strategy.LowHpPyromancer;
import strategy.SuperLowHpPyromancer;

public final class Pyromancer extends Hero {
    public Pyromancer(final int line, final int row, final int givenId) {
        location = new Coordinates(line, row);
        experience = 0;
        level = 0;
        id = givenId;
        healthPoints = Constants.PYROMANCER_BASE_HEALTHPOINTS;
        type = 'P';
        damageOverTime = 0;
        roundsLeftDmg = 0;
        angelModifier = 0f;
        playerStrategy = new BasicPyromancer();
        name = "Pyromancer " + id;
    }

    public void acceptHelp(final Angel angel) {
        angel.help(this);
    }

    public void resetHealthPoints() {
        healthPoints = Constants.PYROMANCER_BASE_HEALTHPOINTS + level
                * Constants.PYROMANCER_HEALTHPOINTS_PER_LEVEL;
    }

    protected float igniteBase() {
        float modifier = landModifier;
        float damage = Constants.IGNITE_BASE_DAMAGE + (level * Constants.IGNITE_DAMAGE_PER_LEVEL);
        damage *= modifier;
        return damage;
    }

    private float igniteOverTime() {
        float modifier = landModifier;
        float damage = Constants.IGNITE_BASE_DAMAGE_PER_ROUND + (level
                * Constants.IGNITE_DAMAGE_PER_ROUND_PER_LEVEL);
        damage *= modifier;
        return damage;
    }

    protected float fireBlast() {
        float modifier = landModifier;
        float damage = Constants.FIREBLAST_BASE_DAMAGE + (level
                * Constants.FIREBLAST_DAMAGE_PER_LEVEL);
        damage *= modifier;
        return damage;
    }

    @Override
    public void isAttackedBy(final Hero hero) {
        hero.attack(this);
    }

    @Override
    public void choseStrategy() {
        if (!this.isStunned()) {
            int maxPossibleHp = (Constants.PYROMANCER_BASE_HEALTHPOINTS + level
                    * Constants.PYROMANCER_HEALTHPOINTS_PER_LEVEL);
            float minHp = ((float) 1 / (float) Constants.PYROMANCER_MIN_LOW_HP_DENOMINATOR)
                    * maxPossibleHp;
            float maxHp = ((float) 1 / (float) Constants.PYROMANCER_MAX_LOW_HP_DENOMINATOR)
                    * maxPossibleHp;
            if ((float) healthPoints > minHp && (float) healthPoints < maxHp) {
                playerStrategy = new LowHpPyromancer();
            } else {
                if ((float) healthPoints < minHp) {
                    playerStrategy = new SuperLowHpPyromancer();
                } else {
                    playerStrategy = new BasicPyromancer();
                }
            }
        }
    }

    @Override
    public void receiveHealth(final int quantity) {
        healthPoints += quantity;
        int maxPossibleHp = Constants.PYROMANCER_BASE_HEALTHPOINTS + level
                * Constants.PYROMANCER_HEALTHPOINTS_PER_LEVEL;
        if (healthPoints > maxPossibleHp) {
            healthPoints = maxPossibleHp;
        }
    }

    @Override
    public void attack(final Rogue rogue) {
        int firstAbilityDmg = Math.round(fireBlast()
                * (Constants.RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_ROGUE + angelModifier
                + strategyBonus));
        int secondAbilityDmg = Math.round(igniteBase()
                * (Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_ROGUE + angelModifier
                + strategyBonus));
        int secondAbilityDmgOverTime = Math.round(igniteOverTime()
                * (Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_ROGUE + angelModifier
                + strategyBonus));
        rogue.setDamageOverTime(secondAbilityDmgOverTime);
        rogue.setRoundsLeftDmg(Constants.IGNITE_ROUNDS_TO_TAKE_DAMAGE);

        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        rogue.sufferDamage(damageDealt);
    }

    @Override
    public void attack(final Pyromancer pyromancer) {
        int firstAbilityDmg = Math.round(fireBlast()
                * (Constants.RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_PYROMANCER + angelModifier
                + strategyBonus));
        int secondAbilityDmg = Math.round(igniteBase()
                * (Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_PYROMANCER + angelModifier
                + strategyBonus));
        int secondAbilityDmgOverTime = Math.round(igniteOverTime()
                * (Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_PYROMANCER + angelModifier
                + strategyBonus));
        pyromancer.setDamageOverTime(secondAbilityDmgOverTime);
        pyromancer.setRoundsLeftDmg(Constants.IGNITE_ROUNDS_TO_TAKE_DAMAGE);

        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        pyromancer.sufferDamage(damageDealt);
    }

    @Override
    public void attack(final Wizard wizard) {
        int firstAbilityDmg = Math.round(fireBlast()
                * (Constants.RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_WIZARD + angelModifier
                + strategyBonus));
        int secondAbilityDmg = Math.round(igniteBase()
                * (Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_WIZARD + angelModifier
                + strategyBonus));
        int secondAbilityDmgOverTime = Math.round(igniteOverTime()
                * (Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_WIZARD + angelModifier
                + strategyBonus));
        wizard.setDamageOverTime(secondAbilityDmgOverTime);
        wizard.setRoundsLeftDmg(Constants.IGNITE_ROUNDS_TO_TAKE_DAMAGE);

        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        wizard.sufferDamage(damageDealt);
    }

    @Override
    public void attack(final Knight knight) {
        int firstAbilityDmg = Math.round(Math.round(fireBlast())
                * (Constants.RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_KNIGHT + angelModifier
                + strategyBonus));
        int secondAbilityDmg = Math.round(Math.round(igniteBase())
                * (Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_KNIGHT + angelModifier
                + strategyBonus));
        int secondAbilityDmgOverTime = Math.round(Math.round(igniteOverTime())
                * (Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_KNIGHT + angelModifier
                + strategyBonus));
        knight.setDamageOverTime(secondAbilityDmgOverTime);
        knight.setRoundsLeftDmg(Constants.IGNITE_ROUNDS_TO_TAKE_DAMAGE);

        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        knight.sufferDamage(damageDealt);
    }
}

