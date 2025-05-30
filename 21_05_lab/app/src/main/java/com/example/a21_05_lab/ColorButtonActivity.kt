package com.example.a21_05_lab

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button

class ColorButtonActivity : AppCompatActivity() {
    private val colors = listOf(
        Color.RED, Color.parseColor("#FFA500"), // Orange
        Color.YELLOW, Color.GREEN,
        Color.parseColor("#00FFFF"), // Cyan
        Color.BLUE, Color.parseColor("#8A2BE2") // Violet
    )
    private var currentColorIndex = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_button)

        val colorButton = findViewById<Button>(R.id.colorButton)

        colorButton.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    Log.d("ColorButton", "ACTION_DOWN detected")
                    currentColorIndex = (currentColorIndex + 1) % colors.size
                    colorButton.setBackgroundColor(colors[currentColorIndex])
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    Log.d("ColorButton", "ACTION_MOVE detected")
                    view.x = event.rawX - view.width / 2
                    view.y = event.rawY - view.height / 2
                    colorButton.text = "Вы перетаскиваете кнопку"
                    currentColorIndex = (currentColorIndex + 1) % colors.size
                    colorButton.setBackgroundColor(colors[currentColorIndex])
                    true
                }
                MotionEvent.ACTION_UP -> {
                    Log.d("ColorButton", "ACTION_UP detected")
                    colorButton.text = "Вы отпустили кнопку"
                    true
                }
                else -> false
            }
        }
    }
}