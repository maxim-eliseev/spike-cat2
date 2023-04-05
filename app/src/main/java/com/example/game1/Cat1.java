package com.example.game1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Cat1 {
    private Bitmap catWalkingRight;
    private Bitmap catWalkingLeft;

    private int x;
    private int y;

    private int xVelocity = 10;
    private int yVelocity = 5;

    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public Cat1(Resources resources, int x, int y, int xVelocity, int yVelocity){
        this.catWalkingLeft = BitmapFactory.decodeResource(resources,R.drawable.cat1_l);
        this.catWalkingRight = BitmapFactory.decodeResource(resources,R.drawable.cat1_r);

        this.x = x;
        this.y = y;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public void update() {
        x += xVelocity;
        y += yVelocity;

        if (x<0 || x > screenWidth - getImageWidth()){
            xVelocity = xVelocity * -1;
        }
        if (y<0 || y > screenHeight - getImageHeight()){
            yVelocity = yVelocity * -1;
        }
    }

    public void draw(Canvas canvas){
        if (xVelocity>=0){
            canvas.drawBitmap(catWalkingRight,x,y,null);
        } else {
            canvas.drawBitmap(catWalkingLeft,x,y,null);
        }
    }

    private int getImageWidth()
    {
        if (xVelocity>=0){
            return catWalkingRight.getWidth();
        } else {
            return catWalkingLeft.getWidth();
        }
    }

    private int getImageHeight()
    {
        if (xVelocity>=0){
            return catWalkingRight.getHeight();
        } else {
            return catWalkingLeft.getHeight();
        }
    }
}
