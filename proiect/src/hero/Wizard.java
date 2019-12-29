package hero;

import angel.Angel;
import common.Constants;
import strategy.BasicWizard;
import strategy.LowHpWizard;
import strategy.SuperLowHpWizard;

public final class Wizard extends Hero {
    public Wizard(final int line, final int row, final int givenId) {
        location = new Coordinates(line, row);
        experience = 0;
        level = 0;
        id = givenId;
        healthPoints = Constants.WIZARD_BASE_HEALTHPOINTS;
        type = 'W';
        damageOverTime = 0;
        roundsLeftDmg = 0;
        angelModifier = 0f;
        playerStrategy = new BasicWizard();
    }

    public void acceptHelp(final Angel angel) {
        angel.help(this);
    }

    public void resetHealthPoints() {
        healthPoints = Constants.WIZARD_BASE_HEALTHPOINTS + level
                * Constants.WIZARD_HEALTHPOINTS_PER_LEVEL;
    }

    private float drain(final float baseOpponentHp) {
        float modifier = landModifier;
        float procent = Constants.DRAIN_BASE_PERCENTAGE + (level
                * Constants.DRAIN_PERCENTAGE_PER_LEVEL);
        float damage = procent * baseOpponentHp;
        damage *= modifier;
        return damage;
    }

    private float deflect(final int damageReceived) {
        float modifier = landModifier;
        float procent = Constants.DEFLECT_BASE_PERCENTAGE + (level
                * Constants.DEFLECT_PERCENTAGE_PER_LEVEL);
        if (procent > Constants.DEFLECT_MAX_PERCENTAGE) {
            procent = Constants.DEFLECT_MAX_PERCENTAGE;
        }
        float damage = procent * damageReceived;
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
            System.out.println("@!#!@#!@#");
            int maxPossibleHp = (Constants.WIZARD_BASE_HEALTHPOINTS + level
                    * Constants.WIZARD_HEALTHPOINTS_PER_LEVEL);
            float minHp = ((float) 1 / (float) Constants.WIZARD_MIN_LOW_HP_DENOMINATOR)
                    * maxPossibleHp;
            float maxHp = ((float) 1 / (float) Constants.WIZARD_MAX_LOW_HP_DENOMINATOR)
                    * maxPossibleHp;
            if ((float) healthPoints > minHp && (float) healthPoints < maxHp) {
                playerStrategy = new LowHpWizard();
            } else {
                if ((float) healthPoints < minHp) {
                    playerStrategy = new SuperLowHpWizard();
                } else {
                    playerStrategy = new BasicWizard();
                }
            }
        }
    }

    @Override
    public void receiveHealth(final int quantity) {
        healthPoints += quantity;
        int maxPossibleHp = Constants.WIZARD_BASE_HEALTHPOINTS + level
                * Constants.WIZARD_HEALTHPOINTS_PER_LEVEL;
        if (healthPoints > maxPossibleHp) {
            healthPoints = maxPossibleHp;
        }
    }

    @Override
    public void attack(final Rogue rogue) {
        int opponentMaxHp = Constants.ROGUE_BASE_HEALTHPOINTS + (rogue.getLevel()
                * Constants.ROGUE_HEALTHPOINTS_PER_LEVEL);
        int opponentCurrentHp = rogue.getHealthPoints();
        float baseOpponentHp = Math.min(Constants.DRAIN_BASE_OPPONENT_HP_PERCENTAGE
                * opponentMaxHp, opponentCurrentHp);
        int firstAbilityDmg = Math.round(drain(baseOpponentHp)
                * (Constants.RACE_MODIFIER_DRAIN_WIZARD_VS_ROUGE + angelModifier));
        float opponentFirstAbilityBaseDmg = rogue.backstab();
        if (rogue.isCritical()) {
            opponentFirstAbilityBaseDmg *= Constants.BACKSTAB_CRITICAL_HIT_MODIFIER;
        }
        int opponentFirstAbilityDmg = Math.round(opponentFirstAbilityBaseDmg);
        int opponentSecondAbilityDmg = Math.round(rogue.paralysis());
        int damageReceived = opponentFirstAbilityDmg + opponentSecondAbilityDmg;
        int secondAbilityDmg = Math.round(deflect(damageReceived)
                * (Constants.RACE_MODIFIER_DEFLECT_WIZARD_VS_ROGUE + angelModifier));
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        rogue.sufferDamage(damageDealt);
    }

    @Override
    public void attack(final Pyromancer pyromancer) {
        int opponentMaxHp = Constants.PYROMANCER_BASE_HEALTHPOINTS + (pyromancer.getLevel()
                * Constants.PYROMANCER_HEALTHPOINTS_PER_LEVEL);
        int opponentCurrentHp = pyromancer.getHealthPoints();
        float baseOpponentHp = Math.min(Constants.DRAIN_BASE_OPPONENT_HP_PERCENTAGE
                * opponentMaxHp, opponentCurrentHp);
        int firstAbilityDmg = Math.round(drain(baseOpponentHp)
                * (Constants.RACE_MODIFIER_DRAIN_WIZARD_VS_PYROMANCER + angelModifier));
        int opponentFirstAbilityDmg = Math.round(pyromancer.fireBlast());
        int opponentSecondAbilityDmg = Math.round(pyromancer.igniteBase());
        int damageReceived = opponentFirstAbilityDmg + opponentSecondAbilityDmg;
        int secondAbilityDmg = Math.round(deflect(damageReceived)
                * (Constants.RACE_MODIFIER_DEFLECT_WIZARD_VS_PYROMANCER + angelModifier));
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        pyromancer.sufferDamage(damageDealt);

    }

    @Override
    public void attack(final Wizard wizard) {
        int opponentMaxHp = Constants.WIZARD_BASE_HEALTHPOINTS + (wizard.getLevel()
                * Constants.WIZARD_HEALTHPOINTS_PER_LEVEL);
        int opponentCurrentHp = wizard.getHealthPoints();
        float baseOpponentHp = Math.min(Constants.DRAIN_BASE_OPPONENT_HP_PERCENTAGE
                * opponentMaxHp, opponentCurrentHp);
        int firstAbilityDmg = Math.round(drain(baseOpponentHp)
                * (Constants.RACE_MODIFIER_DRAIN_WIZARD_VS_WIZARD) + angelModifier);
        int damageDealt = firstAbilityDmg;
        wizard.sufferDamage(damageDealt);
    }

    @Override
    public void attack(final Knight knight) {
        int ownMaxHp = Constants.WIZARD_BASE_HEALTHPOINTS + (level
                * Constants.WIZARD_HEALTHPOINTS_PER_LEVEL);
        int opponentMaxHp = Constants.KNIGHT_BASE_HEALTHPOINTS + (knight.getLevel()
                * Constants.KNIGHT_HEALTHPOINTS_PER_LEVEL);
        int opponentCurrentHp = knight.getHealthPoints();
        float baseOpponentHp = Math.min(Constants.DRAIN_BASE_OPPONENT_HP_PERCENTAGE
                * opponentMaxHp, opponentCurrentHp);
        int firstAbilityDmg = Math.round(drain(baseOpponentHp)
                * (Constants.RACE_MODIFIER_DRAIN_WIZARD_VS_KNIGHT + angelModifier));
//        int opponentFirstAbilityDmg = Math.round(knight.execute(ownMaxHp, healthPoints));
//        if (opponentFirstAbilityDmg == Constants.BIG_DMG_TO_KILL_EVERYTHING) {
//            opponentFirstAbilityDmg = healthPoints;
//        }
        float opponentFirstAbilityDmg = Constants.EXECUTE_BASE_DAMAGE
                + (knight.getLevel() * Constants.EXECUTE_DAMAGE_PER_LEVEL);
        opponentFirstAbilityDmg *= knight.getLandModifier();
        System.out.println(opponentFirstAbilityDmg);
        int opponentSecondAbilityDmg = Math.round(knight.slam());
        int damageReceived = (int) opponentFirstAbilityDmg + opponentSecondAbilityDmg;
        int secondAbilityDmg = Math.round(deflect(damageReceived)
                * (Constants.RACE_MODIFIER_DEFLECT_WIZARD_VS_KNIGHT + angelModifier));
        int damageDealt = firstAbilityDmg + secondAbilityDmg;
        System.out.println(firstAbilityDmg + " + " + secondAbilityDmg + " = " + damageDealt);
        knight.sufferDamage(damageDealt);
    }
}

