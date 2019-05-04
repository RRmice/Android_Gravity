package com.example.android_gravity;

import com.example.android_gravity.clases.LoaderAssets;
import com.example.android_gravity.scene.MainMenuScene;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;


public class Main extends CoreFW {

    public SceneFW getStartScene(){
        LoaderAssets loaderAssets = new LoaderAssets(this, this.getGraphicsFW());
        return new MainMenuScene(this);
    }

}
