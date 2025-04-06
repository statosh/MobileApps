package com.example.a0104;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class BouncingShapeView extends View {

    private float x = 150, y = 150;
    private float dx = 10, dy = 10;
    private int radius = 150;

    private Paint paint;
    private final Handler handler = new Handler();
    private final int frameRate = 15;

    private final Random random = new Random();

    public BouncingShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(randomColor());
    }

    private int randomColor() {
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private final Runnable updater = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        x += dx;
        y += dy;

        if ((x - radius) <= 0 || (x + radius) >= getWidth()) {
            dx *= -1;
            paint.setColor(randomColor());
        }
        if ((y - radius) <= 0 || (y + radius) >= getHeight()) {
            dy *= -1;
            paint.setColor(randomColor());
        }

        canvas.drawCircle(x, y, radius, paint);

        handler.postDelayed(updater, frameRate);
    }
}