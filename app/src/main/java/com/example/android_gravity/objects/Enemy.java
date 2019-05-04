package com.example.android_gravity.objects;

import com.example.android_gravity.utilits.UtilResource;
import com.example.my_framework.AnimationFW;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.ObjectFW;
import com.example.my_framework.utilits.UtilRandomFW;

public class Enemy extends ObjectFW {

    AnimationFW animEnemy;

    public Enemy(int maxScreenX, int maxScreenY, int minScreenY, int enemyType) {

        this.MaxScreenX = maxScreenX;
        this.MaxScreenY = maxScreenY - UtilResource.spriteEnemy.get(0).getHeight();

        this.MinScreenY = minScreenY;
        this.MinScreenX = 0;

        x = maxScreenX;
        y = UtilRandomFW.getGap(minScreenY, maxScreenY);

        switch (enemyType){
            case 1:
                speed = UtilRandomFW.getGap(1, 6);
                animEnemy = new AnimationFW(3, UtilResource.spriteEnemy.get(0), UtilResource.spriteEnemy.get(1),
                        UtilResource.spriteEnemy.get(2), UtilResource.spriteEnemy.get(3));
                break;
            case 2:
                speed = UtilRandomFW.getGap(4, 9);
                break;
        }

    }

    public void update(double speedPlayer){
        x-=speed;
        x-=speedPlayer;

        if(x < MinScreenX){
            x = MaxScreenX;
            y = UtilRandomFW.getGap(MinScreenY, MaxScreenX);
        }

        animEnemy.runAnimation();
    }

    public void drawing(GraphicsFW graphicsFW){
        animEnemy.drawingAnimation(graphicsFW, x, y);
    }

}
