package com.polineniamith.lab07;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.media.MediaPlayer;

public class basketball {
    private float bX, bY, bR = 150f;
    private float velocity;
    private float dv;
    private Paint p;

    public basketball(Paint setPaint, float startX, float startY, float v) {
        p = setPaint;
        bX = startX;
        bY = startY;
        velocity = v;
        dv = velocity;
    }

    public void draw(Canvas c) {
        p.setColor(Color.BLACK);
        c.drawCircle(bX, bY, bR + 7, p);
        p.setColor(Color.argb(255, 255, 135, 3));
        p.setShader(new LinearGradient(bX - bR, bY - bR, bX + bR, bY + bR, Color.argb(255, 255, 135, 3), Color.argb(255, 150, 80, 10), Shader.TileMode.MIRROR));
        c.drawCircle(bX, bY, bR, p);
        p.setColor(Color.BLACK);
        p.setShader(null);
        c.drawRect(bX - bR, bY - 5, bX+bR, bY + 5, p);
        c.drawRect(bX - 5, bY - bR, bX + 5, bY + bR, p);
        p.setStrokeWidth(10);
        c.drawLine((float) (bX + (bR*.707)), (float) (bY - (bR*.707)), (float) (bX + (.5*bR)), bY , p);
        c.drawLine((float) (bX + (bR*.707)), (float) (bY + (bR*.707)), (float) (bX + (.5*bR)), bY , p);
        c.drawLine((float) (bX - (bR*.707)), (float) (bY - (bR*.707)), (float) (bX - (.5*bR)), bY , p);
        c.drawLine((float) (bX - (bR*.707)), (float) (bY + (bR*.707)), (float) (bX - (.5*bR)), bY , p);
    }

    public void update(float height) {
        if((bY + 490) < (0 + 4*bR)){
            dv = velocity;
            MainActivity.mp.stop();
            MainActivity.mp.release();
            MainActivity.mp = MediaPlayer.create(MainActivity.getAppContext(), R.raw.swish);
            MainActivity.mp.start();
        } else if( bY > (height - 500 - 2*bR) ){
            dv = -1*velocity;
            MainActivity.mp.stop();
            MainActivity.mp.release();
            MainActivity.mp = MediaPlayer.create(MainActivity.getAppContext(), R.raw.bounce);
            MainActivity.mp.start();
        }
        bY += dv;
    }

    public void setSpeed(float newSpeed) {
        velocity = newSpeed;
    }
}
