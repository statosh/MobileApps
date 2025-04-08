package com.example.a0804;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class SecondCustomView extends View {

    private Paint paint; // Объект для рисования фигур

    // Конструктор без атрибутов
    public SecondCustomView(Context context) {
        super(context);
        init(); // Инициализация представления
    }

    // Конструктор с атрибутами из XML
    public SecondCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(); // Инициализация представления
    }

    // Конструктор с атрибутами и стилем из XML
    public SecondCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(); // Инициализация представления
    }

    // Метод инициализации представления
    private void init() {
        paint = new Paint(); // Создание объекта Paint
        paint.setStyle(Paint.Style.FILL); // Установка стиля заливки
    }

    // Метод вызывается для отрисовки представления
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Отрисовка фона
        canvas.drawColor(Color.GRAY); // Установка цвета фона

        // Отрисовка травы
        drawGrass(canvas);

        // Отрисовка луны
        drawMoon(canvas);

        // Отрисовка пчелы
        drawBee(canvas);
    }

    // Метод для отрисовки травы
    private void drawGrass(Canvas canvas) {
        paint.setColor(Color.parseColor("#3CB45B")); // Установка цвета травы (тёмно-зелёный)
        float centerY = getHeight() * 0.75f; // Расчёт центра по оси Y
        canvas.drawCircle(700, 2450, 1000, paint); // Отрисовка круга для травы
    }

    // Метод для отрисовки луны
    private void drawMoon(Canvas canvas) {
        float cx = getWidth() * 0.2f; // Расчёт центра луны по оси X
        float cy = getHeight() * 0.2f; // Расчёт центра луны по оси Y
        float radius = 100; // Радиус луны

        // Отрисовка внешнего круга луны
        paint.setColor(Color.WHITE); // Установка цвета луны
        canvas.drawCircle(cx, cy, radius, paint);

        // Отрисовка внутреннего круга для создания полумесяца
        paint.setColor(Color.GRAY); // Установка цвета внутреннего круга
        canvas.drawCircle(cx + 40, cy, radius, paint);
    }

    // Метод для отрисовки пчелы
    private void drawBee(Canvas canvas) {
        float baseX = getWidth() * 0.6f; // Базовая координата X пчелы
        float baseY = getHeight() * 0.6f; // Базовая координата Y пчелы

        // Отрисовка головы пчелы
        paint.setColor(Color.YELLOW); // Установка цвета головы
        canvas.drawRect(baseX - 100, baseY, baseX - 60, baseY + 40, paint); // Отрисовка прямоугольника для головы

        // Отрисовка тела пчелы
        canvas.drawRect(baseX - 60, baseY, baseX + 40, baseY + 80, paint); // Отрисовка прямоугольника для тела

        // Отрисовка полосок на теле пчелы
        paint.setColor(Color.BLACK); // Установка цвета полосок
        canvas.drawRect(baseX - 40, baseY, baseX - 20, baseY + 80, paint); // Отрисовка первой полоски
        canvas.drawRect(baseX, baseY, baseX + 20, baseY + 80, paint); // Отрисовка второй полоски

        // Отрисовка крыла пчелы
        paint.setColor(Color.rgb(173, 216, 230)); // Установка цвета крыла (светло-голубой)
        canvas.drawRect(baseX + 10, baseY - 30, baseX + 90, baseY, paint); // Отрисовка прямоугольника для крыла

        // Отрисовка усиков пчелы
        paint.setColor(Color.BLACK); // Установка цвета усиков
        canvas.drawRect(baseX - 90, baseY - 30, baseX - 85, baseY, paint); // Отрисовка первого усика
        canvas.drawRect(baseX - 70, baseY - 30, baseX - 65, baseY, paint); // Отрисовка второго усика

        // Отрисовка глаза пчелы
        canvas.drawRect(baseX - 85, baseY + 15, baseX - 80, baseY + 20, paint); // Отрисовка прямоугольника для глаза

        // Отрисовка лапок пчелы
        canvas.drawRect(baseX - 40, baseY + 80, baseX - 35, baseY + 90, paint); // Отрисовка первой лапки
        canvas.drawRect(baseX + 20, baseY + 80, baseX + 25, baseY + 90, paint); // Отрисовка второй лапки
    }
}