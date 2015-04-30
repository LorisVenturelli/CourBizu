package com.imerir.courbizu.utils;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by rcdsm on 29/04/15.
 */
public class Constants {

    public static boolean APP_GAME = true;

    public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 480;
    public static final float WORLD_TO_SCREEN = 32;

    public static float WORLD_GRAVITY = -10f;

    public static final float GROUND_X = 0 ;
    public static final float GROUND_Y = 0 ;
    public static final float GROUND_WIDTH = 50f;
    public static final float GROUND_HEIGHT = 2f;
    public static final float GROUND_DENSITY = 0f;

    public static final float RUNNER_X = 2;
    public static final float RUNNER_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float RUNNER_WIDTH = 1f;
    public static final float RUNNER_HEIGHT = 2f;

    public static final float RUNNER_GRAVITY_SCALE = 3f;
    public static float RUNNER_DENSITY = 0.5f;
    public static final float RUNNER_DODGE_X = 2f;
    public static final float RUNNER_DODGE_Y = 1.5f;
    public static float RUNNER_JUMPING_LINEAR_IMPULSE = 15f;
    public static final float RUNNER_HIT_ANGULAR_IMPULSE = 10f;

    public static final float ENEMY_X = 25f;
    public static final float ENEMY_DENSITY = RUNNER_DENSITY;
    public static final float RUNNING_SHORT_ENEMY_Y = 1.5f;
    public static final float RUNNING_LONG_ENEMY_Y = 2f;
    public static final float FLYING_ENEMY_Y = 3f;
    public static float ENEMY_LINEAR_VELOCITY = -10f;
    public static float ENEMY_LINEAR_VELOCITY_MULTIPLIER = 1.08f;

    public static final String BACKGROUND_IMAGE_PATH = "background2.png";
    public static final float COIN_X = 30f;
    public static final float COIN_DENSITY = 10f;
    public static final float FLYING_COIN_Y = 5f;

    public static final Vector2 COIN_LINEAR_VELOCITY = new Vector2(-10f, 0);

    public static final String GROUND_IMAGE_PATH = "ground.png";

   // public static final String WALK_ATLAS_PATH = "walk.txt";
    //public static final String[] WALK_RUNNER_RUNNING_REGION_NAMES = new String[] {"walk1","walk2","walk3","walk4","walk5","walk6","walk7"};

    public static final String WALK_ATLAS_PATH = "run.txt";
    public static final String[] WALK_RUNNER_RUNNING_REGION_NAMES = new String[] {"run1","run2","run3","run4","run5","run6","run7","run8","run9","run10","run11","run12","run13","run14","run15","run16","run17"};

    public static final String HIT_ATLAS_PATH = "hit.txt";
    public static final String[] HIT_RUNNER_RUNNING_REGION_NAMES = new String[] {"hit1", "hit2","hit3","hit4","hit5","hit6","hit7","hit9", "hit10","hit11","hit12"};

    public static final String JUMP_ATLAS_PATH = "jump_2.txt";
    public static final String[] JUMP_RUNNER_RUNNING_REGION_NAMES = new String[] {"jump1","jump2","jump3","jump4","jump5","jump6","jump7","jump8","jump9","jump10"};

    public static final String ROULADE_ATLAS_PATH = "roulade.txt";
    public static final String[] ROULADE_RUNNER_DODGING_REGION_NAMES = new String[] {"roulade1","roulade2","roulade3","roulade4","roulade5","roulade6","roulade7"};

    public static final String CHARACTERS_ATLAS_PATH = "characters.txt";
    public static final String[] RUNNER_RUNNING_REGION_NAMES = new String[] {"alienGreen_run1", "alienGreen_run2"};
    public static final String RUNNER_DODGING_REGION_NAME = "alienGreen_dodge";
    public static final String RUNNER_HIT_REGION_NAME = "alienGreen_hit";
    public static final String RUNNER_JUMPING_REGION_NAME = "alienGreen_jump";

    public static final String[] RUNNING_SMALL_ENEMY_REGION_NAMES = new String[] {"ladyBug_walk1", "ladyBug_walk2"};
    public static final String[] RUNNING_LONG_ENEMY_REGION_NAMES = new String[] {"barnacle_bite1", "barnacle_bite2"};
    public static final String[] RUNNING_BIG_ENEMY_REGION_NAMES = new String[] {"spider_walk1", "spider_walk2"};
    public static final String[] RUNNING_WIDE_ENEMY_REGION_NAMES = new String[] {"worm_walk1", "worm_walk2"};
    public static final String[] FLYING_SMALL_ENEMY_REGION_NAMES = new String[] {"bee_fly1", "bee_fly2"};
    public static final String[] FLYING_WIDE_ENEMY_REGION_NAMES = new String[] {"fly_fly1", "fly_fly2"};
    public static final String[] FLYING_SMALL_COIN_REGION_NAMES = new String[] {"coin_coin", "coin_coin"};


}
