package com.example.my_framework;

public class LoopFW implements Runnable {

    private final float FPS = 60;
    private final float SECOND = 1000000000;
    private final float UPDATE_TIME = SECOND / FPS;

    private boolean RUNNING = false;

    Thread gameThread = null;

    @Override
    public void run() {

        float lastTime = System.nanoTime();
        float delta = 0;

        while (RUNNING){

            float nowTime = System.nanoTime();
            float elapsedTime = nowTime - lastTime;
            lastTime = nowTime;

            delta  += elapsedTime/UPDATE_TIME;

            if (delta > 1){
                updateGame();
                drawingGame();
                delta--;
            }

        }

    }

    private void  updateGame(){

    }

    private void drawingGame(){

    }

    public void startGame(){
        if(RUNNING){
            return;
        }
        RUNNING = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopGame(){
        if(!RUNNING){
            return;
        }
        RUNNING = false;

        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
