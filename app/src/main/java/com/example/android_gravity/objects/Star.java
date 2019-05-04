package com.example.android_gravity.objects;

import com.example.my_framework.ObjectFW;
import com.example.my_framework.utilits.UtilRandomFW;

import java.util.Random;

public class Star extends ObjectFW {

    public Star(int sceneWight, int sceneHeight, int minScreenY) {
        this.MaxScreenX = sceneWight;
        this.MaxScreenY = sceneHeight;

        this.MinScreenX = 0;
        this.MinScreenY = minScreenY;

        this.speed = 2;

        this.x = UtilRandomFW.getCasualNumber(MaxScreenX);
        this.y = UtilRandomFW.getGap(MinScreenY, MaxScreenY);
    }

    public void update(double speedPlayer){
        x -= speedPlayer;
        x -= speed;
        if (x < 0){
            x = MaxScreenX;
            y = UtilRandomFW.getGap(MinScreenY, MaxScreenY);
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
