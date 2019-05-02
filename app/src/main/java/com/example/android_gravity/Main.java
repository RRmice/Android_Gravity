package com.example.android_gravity;

import com.example.android_gravity.scene.MainMenuScene;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;


public class Main extends CoreFW {

    public SceneFW getStartScene(){
        return new MainMenuScene(this);
    }

}
