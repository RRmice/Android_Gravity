package com.example.android_gravity.generator;

import com.example.android_gravity.objects.Enemy;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.ObjectFW;

import java.util.ArrayList;

public class GeneratorEnemy extends ObjectFW {

    private int maxScreenX;
    private int maxScreenY;

    private int minScreenX;
    private int minScreenY;

    ArrayList<Enemy> enemyArrayList;

    public GeneratorEnemy(int screenWidth, int screenHeight,  int minScreenY) {

        this.maxScreenX = screenWidth;
        this.maxScreenY = screenHeight;

        this.minScreenX = 0;
        this.minScreenY = minScreenY;

        enemyArrayList = new ArrayList<>();
    }

    public void update(double speedPlayer){

        if(enemyArrayList.size() < 3){
            addEnemy(speedPlayer,3 );
        }

        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).update(speedPlayer);
        }
    }

    private void addEnemy(double speedPlayer, int ammountEnemy) {
        for (int i = 0; i < ammountEnemy; i++) {
            enemyArrayList.add(new Enemy(maxScreenX, maxScreenY, minScreenY, 1));
        }
    }

    public void drawing(GraphicsFW graphicsFW){
        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).drawing(graphicsFW);
        }
    }


}
