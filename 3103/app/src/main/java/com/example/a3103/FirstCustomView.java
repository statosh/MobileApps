package com.example.a3103;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class FirstCustomView extends View {
    private Paint paint;

    public FirstCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#E6E6FA"));

        paint.setColor(Color.RED);
        canvas.drawCircle(300, 300, 200, paint);
        paint.setColor(Color.parseColor("#FF4500"));
        canvas.drawCircle(400, 400, 200, paint);
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(500, 500, 200, paint);

        paint.setColor(Color.parseColor("#00FF6C"));
        canvas.drawCircle(450, 700, 125, paint);

        paint.setColor(Color.BLACK);
        canvas.drawCircle(400, 650, 15, paint);
        canvas.drawCircle(500, 650, 15, paint);

        paint.setColor(Color.parseColor("#00FF6C"));
        canvas.drawLine(400, 585, 400, 500, paint);
        canvas.drawLine(500, 585, 500, 500, paint);
        canvas.drawCircle(400, 500, 11, paint);
        canvas.drawCircle(500, 500, 11, paint);

        paint.setColor(Color.BLACK);
        canvas.drawLine(400, 750, 500, 750, paint);
    }
}