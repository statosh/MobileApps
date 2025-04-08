package com.example.a0804;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ThirdCustomView extends View {

    private Bitmap imageBitmap; // Объект Bitmap для хранения изображения
    private static final String TAG = "ThirdCustomView"; // Тег для логирования

    // Конструктор без атрибутов
    public ThirdCustomView(Context context) {
        super(context);
        init(); // Инициализация представления
        Log.d(TAG, "ThirdCustomView создан");
    }

    // Конструктор с атрибутами из XML
    public ThirdCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(); // Инициализация представления
        Log.d(TAG, "ThirdCustomView создан с AttributeSet");
    }

    // Конструктор с атрибутами и стилем из XML
    public ThirdCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(); // Инициализация представления
        Log.d(TAG, "ThirdCustomView создан с AttributeSet и defStyle");
    }

    // Метод инициализации представления
    private void init() {
        // Загрузка изображения из ресурсов
        imageBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cowl);
        Log.d(TAG, "Изображение загружено");
    }

    // Метод вызывается для отрисовки представления
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.d(TAG, "Перерисовка ThirdCustomView");

        // Очистка холста белым цветом
        canvas.drawColor(Color.WHITE);

        // Рисование изображения на холсте
        canvas.drawBitmap(imageBitmap, 0, 0, null);
        Log.d(TAG, "Изображение нарисовано");
    }
}