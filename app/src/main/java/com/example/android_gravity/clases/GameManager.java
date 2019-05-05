package com.example.android_gravity.clases;

import com.example.android_gravity.generator.GeneratorBackground;
import com.example.android_gravity.generator.GeneratorEnemy;
import com.example.android_gravity.objects.Enemy;
import com.example.android_gravity.objects.HUD;
import com.example.android_gravity.objects.MainPlayer;
import com.example.my_framework.CollisionDetect;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;

public class GameManager {

    private int maxScreenX;
    private int maxScreenY;

    private int minScreenX;
    private int minScreenY;

    MainPlayer mainPlayer;
    GeneratorBackground generatorBackground;
    GeneratorEnemy generatorEnemy;

    private int passedDistance;
    private int currentSpeedPlayer;
    private int currentShieldsPlayer;

    public static boolean gameOver;

    HUD hud;

    public GameManager(CoreFW coreFW, int screenWidth, int screenHeight){

        hud = new HUD(coreFW);

        this.maxScreenX = screenWidth;
        this.maxScreenY = screenHeight;

        this.minScreenX = 0;
        this.minScreenY = hud.getHEIGHT_HUD();

        mainPlayer = new MainPlayer(coreFW, maxScreenX, maxScreenY, minScreenY);
        generatorBackground = new GeneratorBackground(screenWidth, screenHeight, minScreenY);

        generatorEnemy = new GeneratorEnemy(screenWidth, screenHeight, minScreenY);
        gameOver = false;

    }

    public void update(){
        mainPlayer.update();
        generatorBackground.update(mainPlayer.getSpeedPlayer());
        generatorEnemy.update(mainPlayer.getSpeedPlayer());

        passedDistance += mainPlayer.getSpeedPlayer();
        currentSpeedPlayer = (int) mainPlayer.getSpeedPlayer() * 60;
        currentShieldsPlayer = mainPlayer.getShieldsPlayer();

        hud.update(passedDistance, currentSpeedPlayer, currentShieldsPlayer);

        checkHit();

    }

    private void checkHit() {

        for (int i = 0; i < generatorEnemy.enemyArrayList.size(); i++) {
            Enemy currentEnemy = generatorEnemy.enemyArrayList.get(i);
            if(CollisionDetect.collisionDetect(mainPlayer, currentEnemy)){
                mainPlayer.hitEnemy();
                generatorEnemy.hitPlayer(currentEnemy);
            }
        }

    }

    public void drawing(CoreFW coreFW, GraphicsFW graphicsFW){
        mainPlayer.drawing(graphicsFW);
        generatorBackground.drawing(graphicsFW);
        generatorEnemy.drawing(graphicsFW);

        hud.drawing(graphicsFW);
    }

    public int getPassedDistance() {
        return passedDistance;
    }
}
