package com.example.last_lab_yippie

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private var isGreen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button = findViewById<Button>(R.id.buttonChangeColor)

        button.setOnClickListener {
            button.setBackgroundColor(Color.BLUE)
            isGreen = true

            Handler().postDelayed({
                if (isGreen) {
                    button.setBackgroundColor(Color.GREEN)
                    isGreen = false
                }
            }, 3000)
        }
    }
}