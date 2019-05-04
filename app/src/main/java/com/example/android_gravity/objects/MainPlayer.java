package com.example.android_gravity.objects;

import com.example.my_framework.AnimationFW;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.ObjectFW;
import com.example.android_gravity.utilits.UtilResource;

public class MainPlayer extends ObjectFW {

    final int GRAVITY = -3;
    final int MAX_SPEED = 15;
    final int MIN_SPEED = 1;

    AnimationFW animMainPlayer;
    AnimationFW animMainPlayerBoos;
    CoreFW coreFW;

    boolean boosting;
    private int shieldsPlayer;

    public MainPlayer(CoreFW coreFW, int maxScreenX, int maxScreenY, int minScreenY) {

        x = 20;
        y = 200;

        speed = 3;
        boosting = false;
        shieldsPlayer = 3;

        this.coreFW = coreFW;

        this.MaxScreenX = maxScreenX;
        this.MaxScreenY = maxScreenY - UtilResource.spritePlayer.get(0).getHeight();

        this.MinScreenY = minScreenY;

        animMainPlayer = new AnimationFW(speed, UtilResource.spritePlayer.get(0),
                UtilResource.spritePlayer.get(1), UtilResource.spritePlayer.get(2), UtilResource.spritePlayer.get(3));

        animMainPlayerBoos = new AnimationFW(speed, UtilResource.spritePlayerBoost.get(0),
                UtilResource.spritePlayerBoost.get(1), UtilResource.spritePlayerBoost.get(2), UtilResource.spritePlayerBoost.get(3));

    }

    public void update() {

        if(coreFW.getTouchListenerFW().getTouchDown(0, getMaxScreenY(), getMaxScreenX(), getMaxScreenY())){
            startBoosting();
        }
        if(coreFW.getTouchListenerFW().getTouchUp(0, getMaxScreenY(), getMaxScreenX(), getMaxScreenY())){
            stopBoosting();
        }

        if (boosting){
            speed+=0.1;
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

    }

    private void stopBoosting() {
        boosting = false;
    }

    private void startBoosting() {
        boosting = true;
    }

    public void drawing(GraphicsFW graphicsFW) {

        if (boosting) {
            animMainPlayerBoos.drawingAnimation(graphicsFW, x, y);
        } else {
            animMainPlayer.drawingAnimation(graphicsFW, x, y);
        }
    }

    public double getSpeedPlayer(){
        return speed;
    }

    public int getShieldsPlayer(){
        return shieldsPlayer;
    }
}
