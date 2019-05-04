package com.example.android_gravity.generator;

import android.graphics.Color;

import com.example.android_gravity.objects.Star;
import com.example.my_framework.GraphicsFW;

import java.util.ArrayList;

public class GeneratorBackground {

    public ArrayList<Star> starArrayList = new ArrayList<>();

    public GeneratorBackground(int sceneWight, int sceneHeight, int minScreenY) {
        int starSpeak = 50;

        for (int i = 0; i < starSpeak; i++) {
            Star star = new Star(sceneWight, sceneHeight, minScreenY);
            starArrayList.add(star);
        }   
    }
    
    public void update(double speedPlayer){
        for (Star s: starArrayList) {
            s.update(speedPlayer);
        }
    }
    
    public void drawing(GraphicsFW graphicsFW){
        for (Star s: starArrayList) {
           graphicsFW.drawPixel(s.getX(), s.getY(), Color.WHITE);
        }
    }
    
}
