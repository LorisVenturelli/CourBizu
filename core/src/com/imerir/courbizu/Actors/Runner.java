package com.imerir.courbizu.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.imerir.courbizu.utils.Constants;
import com.imerir.courbizu.box2d.RunnerUserData;

/**
 * Created by rcdsm on 29/04/15.
 */
public class Runner extends GameActor {

    private boolean dodging;
    private boolean jumping;
    private boolean hit;
    private Animation runningAnimation;
    private Animation rouladeAnimation;
    private Animation hitAnimation;
    private Animation jumpingAnimation;
    //private TextureRegion jumpingTexture;
    //private TextureRegion hitTexture;
    private float stateTime;

    public Runner(Body body) {
        super(body);
        //TextureAtlas textureAtlas = new TextureAtlas(Constants.CHARACTERS_ATLAS_PATH);
        TextureAtlas textureAtlas = new TextureAtlas(Constants.WALK_ATLAS_PATH);
        TextureAtlas textureAtlas2 = new TextureAtlas(Constants.ROULADE_ATLAS_PATH);
        TextureAtlas textureAtlas3 = new TextureAtlas(Constants.JUMP_ATLAS_PATH);
        TextureAtlas textureAtlas4 = new TextureAtlas(Constants.HIT_ATLAS_PATH);

        /*TextureRegion[] runningFrames = new TextureRegion[Constants.RUNNER_RUNNING_REGION_NAMES.length];
        for (int i = 0; i < Constants.RUNNER_RUNNING_REGION_NAMES.length; i++) {
            String path = Constants.RUNNER_RUNNING_REGION_NAMES[i];
            runningFrames[i] = textureAtlas.findRegion(path);
        }*/

        TextureRegion[] runningFrames = new TextureRegion[Constants.WALK_RUNNER_RUNNING_REGION_NAMES.length];
        for (int i = 0; i < Constants.WALK_RUNNER_RUNNING_REGION_NAMES.length; i++) {
            String path = Constants.WALK_RUNNER_RUNNING_REGION_NAMES[i];
            runningFrames[i] = textureAtlas.findRegion(path);
        }

        TextureRegion[] dodgingTexture = new TextureRegion[Constants.ROULADE_RUNNER_DODGING_REGION_NAMES.length];
        for (int i = 0; i < Constants.ROULADE_RUNNER_DODGING_REGION_NAMES.length; i++) {
            String path = Constants.ROULADE_RUNNER_DODGING_REGION_NAMES[i];
            dodgingTexture[i] = textureAtlas2.findRegion(path);
        }


        TextureRegion[] jumpTexture = new TextureRegion[Constants.JUMP_RUNNER_RUNNING_REGION_NAMES.length];
        for (int i = 0; i < Constants.JUMP_RUNNER_RUNNING_REGION_NAMES.length; i++) {
            String path = Constants.JUMP_RUNNER_RUNNING_REGION_NAMES[i];
            jumpTexture[i] = textureAtlas3.findRegion(path);
        }

        TextureRegion[] hitTexture = new TextureRegion[Constants.HIT_RUNNER_RUNNING_REGION_NAMES.length];
        for (int i = 0; i < Constants.HIT_RUNNER_RUNNING_REGION_NAMES.length; i++) {
            String path = Constants.HIT_RUNNER_RUNNING_REGION_NAMES[i];
            hitTexture[i] = textureAtlas4.findRegion(path);
        }


        stateTime = 0f;
        runningAnimation = new Animation(0.05f, runningFrames);
        rouladeAnimation = new Animation(0.1f, dodgingTexture);
        jumpingAnimation = new Animation(0.1f, jumpTexture);
        hitAnimation = new Animation(0.05f, hitTexture);

        //jumpingTexture = textureAtlas.findRegion(Constants.RUNNER_JUMPING_REGION_NAME);
        //hitTexture = textureAtlas.findRegion(Constants.RUNNER_HIT_REGION_NAME);


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        float x = screenRectangle.x - (screenRectangle.width * 0.1f);
        float y = screenRectangle.y;
        float width = screenRectangle.width * 1.2f;

        if (dodging) {
            stateTime += Gdx.graphics.getDeltaTime();
           // batch.draw(dodgingTexture, x, y + screenRectangle.height / 4, width, screenRectangle.height * 3 / 4);
            batch.draw(rouladeAnimation.getKeyFrame(stateTime, true), x, y, width, screenRectangle.height);
        } else if (hit) {
            // When he's hit we also want to apply rotation if the body has been rotated
            stateTime += Gdx.graphics.getDeltaTime();
            batch.draw(hitAnimation.getKeyFrame(stateTime, true), x, y, width * 0.5f, screenRectangle.height * 0.5f, width, screenRectangle.height, 1f,
                    1f, (float) Math.toDegrees(body.getAngle()));
        } else if (jumping) {
            stateTime += Gdx.graphics.getDeltaTime();
            batch.draw(jumpingAnimation.getKeyFrame(stateTime, true), x, y, width, screenRectangle.height);
        } else {
            // Running
            stateTime += Gdx.graphics.getDeltaTime();
            batch.draw(runningAnimation.getKeyFrame(stateTime, true), x, y, width, screenRectangle.height);
        }
    }

    @Override
    public RunnerUserData getUserData() {
        return (RunnerUserData) userData;
    }

    public void jump() {

        if (!(jumping || dodging || hit)) {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
        }

    }

    public void landed() {
        jumping = false;
    }

    public void dodge() {
        if (!(jumping || hit)) {
            body.setTransform(getUserData().getDodgePosition(), getUserData().getDodgeAngle());
            dodging = true;
        }
    }

    public void stopDodge() {
        dodging = false;
        // If the runner is hit don't force him back to the running position
        if (!hit) {
            body.setTransform(getUserData().getRunningPosition(), 0f);
        }
    }

    public boolean isDodging() {
        return dodging;
    }

    public void hit() {
        body.applyAngularImpulse(getUserData().getHitAngularImpulse(), true);
        hit = true;
    }

    public boolean isHit() {
        return hit;
    }

}