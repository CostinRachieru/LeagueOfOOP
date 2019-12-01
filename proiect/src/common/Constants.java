package common;

public final class Constants {
    private Constants() {
    }

    public static final int PYROMANCER_BASE_HEALTHPOINTS = 500;
    public static final int PYROMANCER_HEALTHPOINTS_PER_LEVEL = 50;

    public static final int FIREBLAST_BASE_DAMAGE = 350;
    public static final int FIREBLAST_DAMAGE_PER_LEVEL = 50;

    public static final int IGNITE_BASE_DAMAGE = 150;
    public static final int IGNITE_DAMAGE_PER_LEVEL = 20;
    public static final int IGNITE_BASE_DAMAGE_PER_ROUND = 50;
    public static final int IGNITE_DAMAGE_PER_ROUND_PER_LEVEL = 30;
    public static final int IGNITE_ROUNDS_TO_TAKE_DAMAGE = 2;

    public static final float RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_ROGUE = 0.8f;
    public static final float RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_KNIGHT = 1.2f;
    public static final float RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_PYROMANCER = 0.9f;
    public static final float RACE_MODIFIER_FIREBLAST_PYROMANCER_VS_WIZARD = 1.05f;

    public static final float RACE_MODIFIER_IGNITE_PYROMANCER_VS_ROGUE = 0.8f;
    public static final float RACE_MODIFIER_IGNITE_PYROMANCER_VS_KNIGHT = 1.2f;
    public static final float RACE_MODIFIER_IGNITE_PYROMANCER_VS_PYROMANCER = 0.9f;
    public static final float RACE_MODIFIER_IGNITE_PYROMANCER_VS_WIZARD = 1.05f;



    public static final int KNIGHT_BASE_HEALTHPOINTS = 900;
    public static final int KNIGHT_HEALTHPOINTS_PER_LEVEL = 80;

    public static final int EXECUTE_BASE_DAMAGE = 200;
    public static final int EXECUTE_DAMAGE_PER_LEVEL = 30;
    public static final float EXECUTE_BASE_HP_LIMIT = 0.2f;
    public static final int EXECUTE_LEVEL_LIMIT = 20;
    public static final float EXECUTE_MAX_HP_LIMIT = 0.4f;
    public static final int GET_SECOND_DECIMAL = 100;

    public static final int SLAM_BASE_DAMAGE = 100;
    public static final int SLAM_DAMAGE_PER_LEVEL = 40;

    public static final float RACE_MODIFIER_EXECUTE_KNIGHT_VS_ROGUE = 1.15f;
    public static final float RACE_MODIFIER_EXECUTE_KNIGHT_VS_KNIGHT = 1f;
    public static final float RACE_MODIFIER_EXECUTE_KNIGHT_VS_PYROMANCER = 1.10f;
    public static final float RACE_MODIFIER_EXECUTE_KNIGHT_VS_WIZARD = 0.8f;

    public static final float RACE_MODIFIER_SLAM_KNIGHT_VS_ROGUE = 0.8f;
    public static final float RACE_MODIFIER_SLAM_KNIGHT_VS_KNIGHT = 1.2f;
    public static final float RACE_MODIFIER_SLAM_KNIGHT_VS_PYROMANCER = 0.9f;
    public static final float RACE_MODIFIER_SLAM_KNIGHT_VS_WIZARD = 1.05f;



    public static final int ROGUE_BASE_HEALTHPOINTS = 600;
    public static final int ROGUE_HEALTHPOINTS_PER_LEVEL = 40;

    public static final int BACKSTAB_BASE_DAMAGE = 200;
    public static final int BACKSTAB_DAMAGE_PER_LEVEL = 20;
    public static final int BACKSTAB_THIRD_HIT = 3;
    public static final float BACKSTAB_CRITICAL_HIT_MODIFIER = 1.5f;

    public static final int PARALYSIS_BASE_DAMAGE_OVER_TIME = 40;
    public static final int PARALYSIS_DAMAGE_PER_LEVEL = 10;
    public static final int PARALYSIS_BASIC_ROUNDS_OVER_TIME = 3;
    public static final int PARALYSIS_WOODS_ROUNDS_OVER_TIME = 6;

    public static final float RACE_MODIFIER_BACKSTAB_ROGUE_VS_ROGUE = 1.2f;
    public static final float RACE_MODIFIER_BACKSTAB_ROGUE_VS_KNIGHT = 0.9f;
    public static final float RACE_MODIFIER_BACKSTAB_ROGUE_VS_PYROMANCER = 1.25f;
    public static final float RACE_MODIFIER_BACKSTAB_ROGUE_VS_WIZARD = 1.25f;

    public static final float RACE_MODIFIER_PARALYSIS_ROGUE_VS_ROGUE = 0.9f;
    public static final float RACE_MODIFIER_PARALYSIS_ROGUE_VS_KNIGHT = 0.8f;
    public static final float RACE_MODIFIER_PARALYSIS_ROGUE_VS_PYROMANCER = 1.2f;
    public static final float RACE_MODIFIER_PARALYSIS_ROGUE_VS_WIZARD = 1.25f;



    public static final int WIZARD_BASE_HEALTHPOINTS = 400;
    public static final int WIZARD_HEALTHPOINTS_PER_LEVEL = 30;

    public static final float DRAIN_BASE_PERCENTAGE = 0.2f;
    public static final float DRAIN_PERCENTAGE_PER_LEVEL = 0.05f;
    public static final float DRAIN_BASE_OPPONENT_HP_PERCENTAGE = 0.3f;

    public static final float DEFLECT_BASE_PERCENTAGE = 0.35f;
    public static final float DEFLECT_PERCENTAGE_PER_LEVEL = 0.02f;
    public static final float DEFLECT_MAX_PERCENTAGE = 0.7f;

    public static final float RACE_MODIFIER_DRAIN_WIZARD_VS_ROUGE = 0.8f;
    public static final float RACE_MODIFIER_DRAIN_WIZARD_VS_KNIGHT = 1.2f;
    public static final float RACE_MODIFIER_DRAIN_WIZARD_VS_PYROMANCER = 0.9f;
    public static final float RACE_MODIFIER_DRAIN_WIZARD_VS_WIZARD = 1.05f;

    public static final float RACE_MODIFIER_DEFLECT_WIZARD_VS_ROGUE = 1.2f;
    public static final float RACE_MODIFIER_DEFLECT_WIZARD_VS_KNIGHT = 1.4f;
    public static final float RACE_MODIFIER_DEFLECT_WIZARD_VS_PYROMANCER = 1.3f;
    public static final float RACE_MODIFIER_DEFLECT_WIZARD_VS_WIZARD = 0;



    public static final float VOLCANIC_LAND_MODIFIER = 1.25f;
    public static final float LAND_LAND_MODIFIER = 1.15f;
    public static final float DESERT_LAND_MODIFIER = 1.1f;
    public static final float WOODS_LAND_MODIFIER = 1.15f;


    public static final int BASE_EXPERIENCE = 200;
    public static final int EXPERIENCE_BETWEEN_LEVELS = 50;
    public static final int EXPERIENCE_FOR_FIRST_LEVEL = 250;
    public static final int EXPERIENCE_GAINED_FOR_LEVEL = 40;
    public static final int BIG_DMG_TO_KILL_EVERYTHING = 30000;

}
