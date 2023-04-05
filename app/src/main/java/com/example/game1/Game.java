package com.example.game1;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class Game {

    private Cat1 cat1a;
    private Cat1 cat1b;
    private Cat2 cat2;


    public Game(Resources resources){
        cat1a = new Cat1(resources,100,500,10,5);
        cat1b = new Cat1(resources,0,150,5,0);
        cat2 = new Cat2(resources, 0,1000);
    }

    public void update() {
        cat1a.update();
        cat1b.update();
        cat2.update();
    }

    public void draw(Canvas canvas) {
        cat1a.draw(canvas);
        cat1b.draw(canvas);
        cat2.draw(canvas);
    }

    public void onTouchEvent(MotionEvent event) {
        cat2.onTouchEvent(event);
    }
}
