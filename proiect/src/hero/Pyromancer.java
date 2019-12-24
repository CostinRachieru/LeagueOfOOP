package hero;

import angel.Angel;
import common.Constants;

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
    public void attack(final Rogue rogue) {
        int firstAbilityDmg = Math.round(fireBlast()
                * Constants.RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_ROGUE);
        int secondAbilityDmg = Math.round(igniteBase()
                * Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_ROGUE);
        int secondAbilityDmgOverTime = Math.round(igniteOverTime()
                * Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_ROGUE);
        rogue.setDamageOverTime(secondAbilityDmgOverTime);
        rogue.setRoundsLeftDmg(Constants.IGNITE_ROUNDS_TO_TAKE_DAMAGE);

        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        rogue.sufferDamage(damageDealt);
    }

    @Override
    public void attack(final Pyromancer pyromancer) {
        int firstAbilityDmg = Math.round(fireBlast()
                * Constants.RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_PYROMANCER);
        int secondAbilityDmg = Math.round(igniteBase()
                * Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_PYROMANCER);
        int secondAbilityDmgOverTime = Math.round(igniteOverTime()
                * Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_PYROMANCER);
        pyromancer.setDamageOverTime(secondAbilityDmgOverTime);
        pyromancer.setRoundsLeftDmg(Constants.IGNITE_ROUNDS_TO_TAKE_DAMAGE);

        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        pyromancer.sufferDamage(damageDealt);
    }

    @Override
    public void attack(final Wizard wizard) {
        int firstAbilityDmg = Math.round(fireBlast()
                * Constants.RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_WIZARD);
        int secondAbilityDmg = Math.round(igniteBase()
                * Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_WIZARD);
        int secondAbilityDmgOverTime = Math.round(igniteOverTime()
                * Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_WIZARD);
        wizard.setDamageOverTime(secondAbilityDmgOverTime);
        wizard.setRoundsLeftDmg(Constants.IGNITE_ROUNDS_TO_TAKE_DAMAGE);

        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        wizard.sufferDamage(damageDealt);
    }

    @Override
    public void attack(final Knight knight) {
        int firstAbilityDmg = Math.round(fireBlast()
                * Constants.RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_KNIGHT);
        int secondAbilityDmg = Math.round(igniteBase()
                * Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_KNIGHT);
        int secondAbilityDmgOverTime = Math.round(igniteOverTime()
                * Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_KNIGHT);
        knight.setDamageOverTime(secondAbilityDmgOverTime);
        knight.setRoundsLeftDmg(Constants.IGNITE_ROUNDS_TO_TAKE_DAMAGE);

        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        knight.sufferDamage(damageDealt);
    }
}

