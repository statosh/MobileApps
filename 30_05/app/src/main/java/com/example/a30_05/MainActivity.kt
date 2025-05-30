package com.example.a30_05

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switchButton = findViewById<Button>(R.id.switchButton)
        val colorButton = findViewById<Button>(R.id.colorButton)

        switchButton.setOnClickListener {
            startActivity(Intent(this, SwitchActivity::class.java))
        }

        colorButton.setOnClickListener {
            startActivity(Intent(this, ColorButtonActivity::class.java))
        }
    }
}