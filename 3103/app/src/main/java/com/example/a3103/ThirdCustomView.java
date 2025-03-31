package com.example.a3103;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ThirdCustomView extends View {
    private Paint paint;

    public ThirdCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int viewWidth = getWidth();
        int viewHeight = getHeight();

        float houseWidth = 200;
        float houseHeight = 200;
        float roofHeight = 100;
        float houseLeft = (viewWidth - houseWidth) / 2;
        float houseBottom = viewHeight - 150;
        float houseTop = houseBottom - houseHeight;
        float houseRight = houseLeft + houseWidth;
        float roofTop = houseTop - roofHeight;

        paint.setColor(Color.GREEN);
        canvas.drawRect(0, houseBottom, viewWidth, viewHeight, paint);

        paint.setColor(Color.parseColor("#8B4513"));
        canvas.drawRect(houseLeft, houseTop, houseRight, houseBottom, paint);

        paint.setColor(Color.RED);
        float[] points = {
                houseLeft, houseTop,
                (houseLeft + houseRight) / 2, roofTop,
                houseRight, houseTop
        };
        canvas.drawVertices(Canvas.VertexMode.TRIANGLES, 6, points, 0, null, 0, null, 0, null, 0, 0, paint);

        float windowSize = 100;
        float windowLeft = houseLeft + (houseWidth - windowSize) / 2;
        float windowTop = houseTop + (houseHeight - windowSize) / 2;
        paint.setColor(Color.CYAN);
        canvas.drawRect(windowLeft, windowTop, windowLeft + windowSize, windowTop + windowSize, paint);
    }
}