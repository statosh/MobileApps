package com.example.a2603;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class SnowmanView extends View {

    private Paint whitePaint, blackPaint, pinkPaint;

    public SnowmanView(Context context) {
        super(context);
        init();
    }

    public SnowmanView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        whitePaint = new Paint();
        whitePaint.setColor(Color.WHITE);
        whitePaint.setStyle(Paint.Style.FILL);
        whitePaint.setAntiAlias(true);

        blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStyle(Paint.Style.FILL);
        blackPaint.setAntiAlias(true);

        pinkPaint = new Paint();
        pinkPaint.setColor(Color.parseColor("#FF69B4"));
        pinkPaint.setStyle(Paint.Style.FILL);
        pinkPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.DKGRAY);
        float width = getWidth();
        float height = getHeight();
        drawSnowman(canvas, width * 0.35f, height * 0.5f, 130f);
        drawSnowman(canvas, width * 0.56f, height * 0.5f, 100f);
        drawSnowman(canvas, width * 0.715f, height * 0.5f, 70f);
        canvas.drawCircle(width * 0.4f, height * 0.67f, 130f, whitePaint);
        canvas.drawCircle(width * 0.58f, height * 0.71f, 50f, whitePaint);
        canvas.drawCircle(width * 0.67f, height * 0.73f, 15f, blackPaint);
        canvas.drawCircle(width * 0.71f, height * 0.73f, 15f, blackPaint);
        drawTriangle(canvas, width * 0.78f, height * 0.725f, 60f);
    }

    private void drawSnowman(Canvas canvas, float centerX, float centerY, float bodyRadius) {
        float headRadius = bodyRadius * 0.35f;
        canvas.drawCircle(centerX, centerY, bodyRadius, whitePaint);
        float headY = centerY - bodyRadius - headRadius;
        canvas.drawCircle(centerX, headY, headRadius, whitePaint);
        float eyeRadius = headRadius * 0.2f;
        float eyeOffsetX = headRadius * 0.3f;
        float eyeOffsetY = headRadius * 0.45f;
        canvas.drawCircle(centerX - eyeOffsetX, headY - eyeOffsetY, eyeRadius, blackPaint);
        canvas.drawCircle(centerX + eyeOffsetX, headY - eyeOffsetY, eyeRadius, blackPaint);
        float noseRadius = headRadius * 0.3f;
        canvas.drawCircle(centerX, headY, noseRadius, pinkPaint);
    }

    private void drawTriangle(Canvas canvas, float centerX, float baseY, float size) {
        Path path = new Path();
        path.moveTo(centerX, baseY - size);
        path.lineTo(centerX - size / 2, baseY + size / 2);
        path.lineTo(centerX + size / 2, baseY + size / 2);
        path.close();
        canvas.drawPath(path, pinkPaint);
    }
}