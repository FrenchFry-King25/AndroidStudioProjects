package com.polineniamith.lab07;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {

    private Paint p = new Paint();
    private int y = 0, dy = 10;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.BLUE);
        canvas.drawCircle(500, y, 150f, p);
        float bX = 1000f, bY = 300f, bR = 75f;
        p.setColor(Color.argb(255, 255, 135, 3));
        canvas.drawCircle(bX, bY, bR*2, p);
        p.setColor(Color.BLACK);
        canvas.drawRect(bX - bR, bY - 5, bX+bR, bY + 5, p);
        y += dy;
        y %= (getHeight() - 500);
        invalidate();
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
