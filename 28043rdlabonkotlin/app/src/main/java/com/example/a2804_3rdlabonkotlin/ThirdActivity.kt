package com.example.a2804_3rdlabonkotlin

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.widget.Button

class ThirdActivity : Activity() {

    private var isGreen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val button = findViewById<Button>(R.id.buttonChangeColor)

        button.setOnClickListener {
            button.setBackgroundColor(Color.parseColor("#90EE90"))
            isGreen = true

            Handler().postDelayed({
                if (isGreen) {
                    button.setBackgroundResource(R.drawable.button_border)
                    isGreen = false
                }
            }, 2000)
        }
    }
}