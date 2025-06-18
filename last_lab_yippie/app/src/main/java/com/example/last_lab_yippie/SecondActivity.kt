package com.example.last_lab_yippie

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var button: Button
    private var isGreen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        button = findViewById(R.id.buttonChangeColor)

        button.setOnClickListener {
            button.backgroundTintList = ColorStateList.valueOf(Color.BLUE)
            isGreen = true

            Handler(Looper.getMainLooper()).postDelayed({
                if (isGreen) {
                    button.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
                    isGreen = false
                }
            }, 3000)
        }
    }
}
