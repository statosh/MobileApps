package com.example.a3103;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.animation.ValueAnimator;

public class FourthCustomView extends View {
    private Paint paint;
    private int squareColor = Color.BLUE;
    private float squareY = 200f;
    private boolean movingUp = true;

    public FourthCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        startColorAnimation();
        startPositionAnimation();
    }

    private void startColorAnimation() {
        ValueAnimator colorAnimator = ValueAnimator.ofArgb(
                Color.GREEN,
                Color.CYAN,
                Color.parseColor("#800080")
        );
        colorAnimator.setDuration(3000);
        colorAnimator.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimator.setRepeatMode(ValueAnimator.REVERSE);
        colorAnimator.addUpdateListener(animation -> {
            squareColor = (int) animation.getAnimatedValue();
            invalidate();
        });
        colorAnimator.start();
    }

    private void startPositionAnimation() {
        ValueAnimator positionAnimator = ValueAnimator.ofFloat(100f, 400f);
        positionAnimator.setDuration(2000);
        positionAnimator.setRepeatCount(ValueAnimator.INFINITE);
        positionAnimator.setRepeatMode(ValueAnimator.REVERSE);
        positionAnimator.addUpdateListener(animation -> {
            squareY = (float) animation.getAnimatedValue();
            invalidate();
        });
        positionAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.BLACK);

        paint.setColor(squareColor);
        canvas.drawRect(250, squareY, 500, squareY + 250, paint);
    }
}