package hero;

import common.Constants;

import static common.Constants.FIREBLAST_BASE_DAMAGE;
import static common.Constants.PYROMANCER_HEALTHPOINTS_PER_LEVEL;

public final class Pyromancer extends Hero {
    public Pyromancer(int line, int row, int givenId) {
        location = new Coordinates(line, row);
        experience = 0;
        level = 0;
        id = givenId;
        healthPoints = Constants.PYROMANCER_BASE_HEALTHPOINTS;
        type = 'P';
        damageOverTime = 0;
        roundsLeftDmg = 0;
    }

    public void resetHealthPoints() {
        healthPoints = Constants.PYROMANCER_BASE_HEALTHPOINTS + level * PYROMANCER_HEALTHPOINTS_PER_LEVEL;
    }

    private float igniteBase() {
        float modifier = landModifier;
        float damage = Constants.IGNITE_BASE_DAMAGE + (level * Constants.IGNITE_DAMAGE_PER_LEVEL);
        damage *= modifier;
        return damage;
    }

    private float igniteOverTime() {
        float modifier = landModifier;
        float damage = Constants.IGNITE_BASE_DAMAGE_PER_ROUND + (level * Constants.IGNITE_DAMAGE_PER_ROUND_PER_LEVEL);
        damage *= modifier;
        return damage;
    }

    private float fireBlast() {
        float modifier = landModifier;
        float damage = Constants.FIREBLAST_BASE_DAMAGE + (level * Constants.FIREBLAST_DAMAGE_PER_LEVEL);
        damage *= modifier;
        return damage;
    }

    @Override
    public void isAttackedBy(Hero hero) {
        hero.attack(this);
    }

    @Override
    public void attack(Rogue rogue) {
        System.out.println("Pyromancer vs. Rogue");
        int firstAbilityDmg = Math.round(fireBlast() *
                Constants.RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_KNIGHT);
        System.out.println("FireBlast: " + firstAbilityDmg);
        int secondAbilityDmg = Math.round(igniteBase() *
                Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_KNIGHT);
        System.out.println(("Ignite: " + secondAbilityDmg));
        int secondAbilityDmgOverTime = Math.round(igniteOverTime() *
                Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_KNIGHT);
        System.out.println("IgniteOverTime: " + secondAbilityDmgOverTime);
        rogue.setDamageOverTime(secondAbilityDmgOverTime);
        rogue.setRoundsLeftDmg(Constants.IGNITE_ROUNDS_TO_TAKE_DAMAGE);

        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        rogue.sufferDamage(damageDealt);
    }

    @Override
    public void attack(Pyromancer pyromancer) {
        System.out.println("Pyromancer vs. Pyromancer");
        int firstAbilityDmg = Math.round(fireBlast() *
                Constants.RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_KNIGHT);
        System.out.println("FireBlast: " + firstAbilityDmg);
        int secondAbilityDmg = Math.round(igniteBase() *
                Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_KNIGHT);
        System.out.println(("Ignite: " + secondAbilityDmg));
        int secondAbilityDmgOverTime = Math.round(igniteOverTime() *
                Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_KNIGHT);
        System.out.println("IgniteOverTime: " + secondAbilityDmgOverTime);
        pyromancer.setDamageOverTime(secondAbilityDmgOverTime);
        pyromancer.setRoundsLeftDmg(Constants.IGNITE_ROUNDS_TO_TAKE_DAMAGE);

        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        pyromancer.sufferDamage(damageDealt);
    }

    @Override
    public void attack(Wizard wizard) {
        System.out.println("Pyromancer vs. Wizard");
        int firstAbilityDmg = Math.round(fireBlast() *
                Constants.RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_KNIGHT);
        System.out.println("FireBlast: " + firstAbilityDmg);
        int secondAbilityDmg = Math.round(igniteBase() *
                Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_KNIGHT);
        System.out.println(("Ignite: " + secondAbilityDmg));
        int secondAbilityDmgOverTime = Math.round(igniteOverTime() *
                Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_KNIGHT);
        System.out.println("IgniteOverTime: " + secondAbilityDmgOverTime);
        wizard.setDamageOverTime(secondAbilityDmgOverTime);
        wizard.setRoundsLeftDmg(Constants.IGNITE_ROUNDS_TO_TAKE_DAMAGE);

        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        wizard.sufferDamage(damageDealt);
    }

    @Override
    public void attack(Knight knight) {
        System.out.println("Pyromancer vs. Knight");
        int firstAbilityDmg = Math.round(fireBlast() *
                Constants.RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_KNIGHT);
        System.out.println("FireBlast: " + firstAbilityDmg);
        int secondAbilityDmg = Math.round(igniteBase() *
                Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_KNIGHT);
        System.out.println(("Ignite: " + secondAbilityDmg));
        int secondAbilityDmgOverTime = Math.round(igniteOverTime() *
                Constants.RACE_MODIFIER_IGNITE_PYROMANCER_VS_KNIGHT);
        System.out.println("IgniteOverTime: " + secondAbilityDmgOverTime);
        knight.setDamageOverTime(secondAbilityDmgOverTime);
        knight.setRoundsLeftDmg(Constants.IGNITE_ROUNDS_TO_TAKE_DAMAGE);

        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        knight.sufferDamage(damageDealt);
    }
}

