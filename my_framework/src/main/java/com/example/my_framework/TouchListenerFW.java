package com.example.my_framework;

import android.view.MotionEvent;
import android.view.View;

public class TouchListenerFW implements View.OnTouchListener {

    float touchX;
    float touchY;

    boolean isTouchDown;
    boolean isTouchUp;

    float sceneWight;
    float sceneHeight;

    public TouchListenerFW(View view, float sceneWight, float sceneHeight) {
        view.setOnTouchListener(this);
        this.sceneWight = sceneWight;
        this.sceneHeight = sceneHeight;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        synchronized (this){
            isTouchDown = false;
            isTouchUp   = false;

            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    touchX = event.getX()*sceneWight;
                    touchY = event.getY()*sceneHeight;
                    isTouchDown = true;
                    isTouchUp   = false;
                    break;
                case  MotionEvent.ACTION_UP:
                    touchX = event.getX()*sceneWight;
                    touchY = event.getY()*sceneHeight;
                    isTouchDown = false;
                    isTouchUp   = true;
                    break;
            }
        }

        return true;
    }


    public boolean getTouchUp(int x, int y, int touchWight, int touchHeight){

        if(isTouchUp){
            if (touchX >= x && touchX <= x + touchWight-1 && touchY <= y && touchY >= y - (touchHeight-1)){
                isTouchUp = false;
                return true;
            }
        }

        return false;

    }

    public boolean getTouchDown(int x, int y, int touchWight, int touchHeight){

        if(isTouchDown){
            if (touchX >= x && touchX <= x + touchWight-1 && touchY <= y && touchY >= y - (touchHeight-1)){
                isTouchDown = false;
                return true;
            }
        }

        return false;

    }
}
