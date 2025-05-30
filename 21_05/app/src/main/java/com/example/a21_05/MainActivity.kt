package com.example.a21_05

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    view.setBackgroundColor(Color.GREEN)
                    true
                }
                MotionEvent.ACTION_UP -> {
                    view.setBackgroundColor(Color.BLUE)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    view.x = event.rawX - view.width / 2
                    view.y = event.rawY - view.height / 2
                    view.setBackgroundColor(Color.YELLOW)
                    true
                }
                else -> {false}
            }
        }
    }
}