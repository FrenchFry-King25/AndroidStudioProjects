package com.polineniamith.lab07;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {

    private Paint p = new Paint();
    private int y = 300, dy = 10;
    float bX = 1000f, bY = 300f, bR = 150f;

    private basketball[] bballs;

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

         bballs = new basketball[]{new basketball(p, 1200f, 700f, 10), new basketball(p, 250f, 500f, 20), new basketball(p, 750f, 300f, 15)};
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(int i = 0; i < bballs.length; i++) {
            bballs[i].update(getHeight());
            bballs[i].draw(canvas);
        }


        invalidate();

    }

    public void faster() {
        bballs[0].setSpeed(17);
        bballs[1].setSpeed(17);
        bballs[2].setSpeed(22);
    }

    public void slower() {
        bballs[0].setSpeed(7);
        bballs[1].setSpeed(17);
        bballs[2].setSpeed(12);
    }
}
