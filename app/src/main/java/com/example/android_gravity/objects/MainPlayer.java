package com.example.android_gravity.objects;

import android.graphics.Rect;

import com.example.android_gravity.clases.GameManager;
import com.example.my_framework.AnimationFW;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.ObjectFW;
import com.example.android_gravity.utilits.UtilResource;
import com.example.my_framework.utilits.UtilTimerDelayFW;

public class MainPlayer extends ObjectFW {

    final int GRAVITY = -3;
    final int MAX_SPEED = 15;
    final int MIN_SPEED = 1;

    AnimationFW animMainPlayer;
    AnimationFW animMainPlayerBoos;
    AnimationFW animExplosionPlayer;
    CoreFW coreFW;

    boolean boosting;
    private int shieldsPlayer;
    boolean hitEnemy;
    boolean isGameOver;

    UtilTimerDelayFW timerShieldHit;
    UtilTimerDelayFW timerOnGameOver;

    public MainPlayer(CoreFW coreFW, int maxScreenX, int maxScreenY, int minScreenY) {

        x = 20;
        y = 200;

        speed = 3;
        boosting = false;
        shieldsPlayer = 3;
        hitEnemy = false;
        isGameOver = false;


        radius = UtilResource.spritePlayer.get(0).getWidth()/4;

        this.coreFW = coreFW;

        this.MaxScreenX = maxScreenX;
        this.MaxScreenY = maxScreenY - UtilResource.spritePlayer.get(0).getHeight();

        this.MinScreenY = minScreenY;

        timerShieldHit = new UtilTimerDelayFW();
        timerOnGameOver = new UtilTimerDelayFW();

        animMainPlayer = new AnimationFW(speed, UtilResource.spritePlayer.get(0),
                UtilResource.spritePlayer.get(1), UtilResource.spritePlayer.get(2), UtilResource.spritePlayer.get(3));

        animMainPlayerBoos = new AnimationFW(speed, UtilResource.spritePlayerBoost.get(0),
                UtilResource.spritePlayerBoost.get(1), UtilResource.spritePlayerBoost.get(2), UtilResource.spritePlayerBoost.get(3));

        animExplosionPlayer = new AnimationFW(speed, UtilResource.spriteExplosionPlayer.get(0),
                UtilResource.spriteExplosionPlayer.get(1), UtilResource.spriteExplosionPlayer.get(2), UtilResource.spriteExplosionPlayer.get(3));

    }

    public void update() {

        if(coreFW.getTouchListenerFW().getTouchDown(0, getMaxScreenY(), getMaxScreenX(), getMaxScreenY())){
            startBoosting();
        }
        if(coreFW.getTouchListenerFW().getTouchUp(0, getMaxScreenY(), getMaxScreenX(), getMaxScreenY())){
            stopBoosting();
        }

        if (boosting){
            speed+=0.2;
        } else {
            speed-=3;
        }

        if (speed > MAX_SPEED){
            speed = MAX_SPEED;
        }
        if (speed < MIN_SPEED){
            speed = MIN_SPEED;
        }

        y -= speed + GRAVITY;
        if (y < MinScreenY) {
            y = MinScreenY;
        }
        if (y > MaxScreenY) {
            y = MaxScreenY;
        }

        if(boosting){
            animMainPlayerBoos.runAnimation();
        } else {
            animMainPlayer.runAnimation();
        }


        hitBox = new Rect(x, y,
                UtilResource.spritePlayer.get(0).getWidth(),
                UtilResource.spritePlayer.get(0).getHeight());

        if(isGameOver){
           animExplosionPlayer.runAnimation();
        }

    }

    private void stopBoosting() {
        boosting = false;
    }

    private void startBoosting() {
        boosting = true;
    }

    public void drawing(GraphicsFW graphicsFW) {

        if(!isGameOver) {

            if (!hitEnemy) {
                if (boosting) {
                    animMainPlayerBoos.drawingAnimation(graphicsFW, x, y);
                } else {
                    animMainPlayer.drawingAnimation(graphicsFW, x, y);
                }
            } else {

                graphicsFW.drawTexture(UtilResource.shieldHitEnemy, x, y);
                if (timerShieldHit.timerDelay(0.2)) {
                    hitEnemy = false;
                } else hitEnemy = true;

            }
        } else {
            animExplosionPlayer.drawingAnimation(graphicsFW, x, y);
            if(timerOnGameOver.timerDelay(0.5)){
                GameManager.gameOver = true;
            }
        }


    }

    public double getSpeedPlayer(){
        return speed;
    }

    public int getShieldsPlayer(){
        return shieldsPlayer;
    }

    public void hitEnemy() {
        shieldsPlayer--;
        if(shieldsPlayer < 0){
            isGameOver = true;
            timerOnGameOver.startTimer();
        }
        hitEnemy = true;
        timerShieldHit.startTimer();
    }
}
