package com.example.a0804;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class FirstCustomView extends View {

    private Paint paint; // Объект для рисования фигур
    private int circleRadius = 50; // Радиус круга
    private int circleX = 0; // Координата X круга
    private int circleY = 0; // Координата Y круга
    private int speed = 10; // Скорость движения круга
    private int step = 0; // Шаг для определения целевой точки

    private int width, height; // Ширина и высота представления

    private int[] pointsX; // Массив координат X точек для движения круга
    private int[] pointsY; // Массив координат Y точек для движения круга

    // Конструктор без атрибутов
    public FirstCustomView(Context context) {
        super(context);
        init(); // Инициализация представления
    }

    // Конструктор с атрибутами из XML
    public FirstCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(); // Инициализация представления
    }

    // Конструктор с атрибутами и стилем из XML
    public FirstCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(); // Инициализация представления
    }

    // Метод инициализации представления
    private void init() {
        paint = new Paint(); // Создание объекта Paint
        paint.setColor(Color.BLUE); // Установка цвета заливки
        paint.setStyle(Paint.Style.FILL); // Установка стиля заливки
    }

    // Метод вызывается при изменении размеров представления
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w; // Сохранение ширины представления
        height = h; // Сохранение высоты представления

        // Вычисление координат точек для движения круга
        int thirdHeight = height / 3;
        int quarterWidth = width / 4;
        int fullWidth = width;
        int fullHeight = height;

        pointsX = new int[] {quarterWidth, quarterWidth, fullWidth, fullWidth, 0, 0};
        pointsY = new int[] {0, thirdHeight, thirdHeight, fullHeight, fullHeight, 0};

        circleX = 0; // Начальная координата X круга
        circleY = 0; // Начальная координата Y круга
    }

    // Метод вызывается для отрисовки представления
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE); // Очистка холста белым цветом
        canvas.drawCircle(circleX, circleY, circleRadius, paint); // Отрисовка круга
        moveCircle(); // Перемещение круга
        postInvalidateDelayed(30); // Запрос перерисовки через 30 мс
    }

    // Метод для перемещения круга
    private void moveCircle() {
        int targetX = pointsX[step]; // Целевая координата X
        int targetY = pointsY[step]; // Целевая координата Y

        // Вычисление направления движения
        int dx = Integer.compare(targetX, circleX);
        int dy = Integer.compare(targetY, circleY);

        // Обновление координат круга
        if (circleX != targetX) circleX += dx * speed;
        if (circleY != targetY) circleY += dy * speed;

        // Переход к следующей точке, если цель достигнута
        if (circleX == targetX && circleY == targetY) {
            step = (step + 1) % pointsX.length;
        }
    }
}