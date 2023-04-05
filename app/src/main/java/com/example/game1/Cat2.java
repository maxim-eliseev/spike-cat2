package com.example.game1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class Cat2 {
    private Bitmap catWalkingRight;
    private Bitmap catWalkingLeft;

    private int x;
    private int y;

    private int xVelocity;
    private int yVelocity;

    private int targetX;
    private int targetY;

    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public Cat2(Resources resources, int x, int y){
        this.catWalkingLeft = BitmapFactory.decodeResource(resources,R.drawable.cat1_l);
        this.catWalkingRight = BitmapFactory.decodeResource(resources,R.drawable.cat1_r);

        this.x = x;
        this.y = y;
        this.targetX = x;
        this.targetY = y;
        this.xVelocity = 0;
        this.yVelocity = 0;
    }

    public void update() {
        if (areFarAway(x, targetX)){
            x += xVelocity;
        }

        if (areFarAway(y, targetY)){
            y += yVelocity;
        }
    }

    private boolean areFarAway(int current, int target) {
        if (Math.abs(current - target) > 50){
            return true;
        }
        return false;
    }

    public void draw(Canvas canvas){
        if (xVelocity>=0){
            canvas.drawBitmap(catWalkingRight,x,y,null);
        } else {
            canvas.drawBitmap(catWalkingLeft,x,y,null);
        }
    }

    public void onTouchEvent(MotionEvent event) {
        targetX = Math.round(event.getX());
        targetY = Math.round(event.getY());

        xVelocity = (targetX - x) / 100;
        yVelocity = (targetY - y) / 100;
    }
}
