package com.example.my_framework;

import android.graphics.Rect;

public abstract class ObjectFW {

    protected int MaxScreenX;
    protected int MaxScreenY;
    protected int MinScreenX;
    protected int MinScreenY;

    protected int x;
    protected int y;

    protected double speed;

    protected Rect hitBox;
    protected double radius;

    public int getMaxScreenX() {
        return MaxScreenX;
    }

    public void setMaxScreenX(int maxScreenX) {
        MaxScreenX = maxScreenX;
    }

    public int getMaxScreenY() {
        return MaxScreenY;
    }

    public void setMaxScreenY(int maxScreenY) {
        MaxScreenY = maxScreenY;
    }

    public int getMinScreenX() {
        return MinScreenX;
    }

    public void setMinScreenX(int minScreenX) {
        MinScreenX = minScreenX;
    }

    public int getMinScreenY() {
        return MinScreenY;
    }

    public void setMinScreenY(int minScreenY) {
        MinScreenY = minScreenY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Rect getHitBox() {
        return hitBox;
    }

    public void setHitBox(Rect hitBox) {
        this.hitBox = hitBox;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
