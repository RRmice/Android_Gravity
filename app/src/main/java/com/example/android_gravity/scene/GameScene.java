package com.example.android_gravity.scene;

import android.graphics.Color;

import com.example.android_gravity.R;
import com.example.android_gravity.clases.GameManager;
import com.example.android_gravity.generator.GeneratorBackground;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class GameScene extends SceneFW {

    enum GameState {
        READY, RUNNING, PAUSE, GAMEOVER;
    }

    GameState gameState;
    GameManager gameManager;


    public GameScene(CoreFW coreFW) {
        super(coreFW);
        gameState = GameState.READY;
        gameManager = new GameManager(coreFW, sceneWidth, sceneHeight);
    }

    @Override
    public void update() {

        if (gameState == GameState.READY) {
            updateStateReady();
        }
        if (gameState == GameState.RUNNING) {
            updateStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            updateStatePause();
        }
        if (gameState == GameState.GAMEOVER) {
            updateStateGameOver();
        }
    }


    @Override
    public void drawing() {

        if (gameState == GameState.READY) {
            drawingStateReady();
        }
        if (gameState == GameState.RUNNING) {
            drawingStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            drawingStatePause();
        }
        if (gameState == GameState.GAMEOVER) {
            drawingStateGameOver();
        }

    }


    private void drawingStateGameOver() {
    }

    private void updateStateGameOver() {
    }


    private void drawingStatePause() {
    }

    private void updateStatePause() {
    }


    private void drawingStateRunning() {
        graphicsFW.clearScene(Color.BLACK);
        gameManager.drawing(coreFW, graphicsFW);
    }

    private void updateStateRunning() {
        gameManager.update();
    }

    private void drawingStateReady() {
       graphicsFW.clearScene(Color.BLACK);
       graphicsFW.drawText(coreFW.getString(R.string.txt_gameScene_stateReady_ready),
               250, 300, Color.WHITE, 60, null );
    }

    private void updateStateReady() {
       if(coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)){
           gameState = GameState.RUNNING;
       }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
