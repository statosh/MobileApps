package com.example.a3103;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.animation.ValueAnimator;

public class SecondCustomView extends View {
    private Paint paint;
    private float cloudRadius1 = 50f;
    private float cloudRadius2 = 40f;
    private boolean increasing = true;

    public SecondCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        startAnimation();
    }

    private void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(40f, 60f);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.addUpdateListener(animation -> {
            cloudRadius1 = (float) animation.getAnimatedValue();
            cloudRadius2 = cloudRadius1 * 0.8f;
            invalidate();
        });
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.LTGRAY);

        paint.setColor(Color.parseColor("#87CEEB"));
        canvas.drawCircle(200, 150, cloudRadius1, paint);
        canvas.drawCircle(250, 150, cloudRadius2, paint);
        canvas.drawCircle(200, 200, cloudRadius2, paint);
        canvas.drawCircle(250, 200, cloudRadius1, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawCircle(200, 400, 50, paint);
    }
}