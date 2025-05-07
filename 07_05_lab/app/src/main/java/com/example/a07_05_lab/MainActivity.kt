package com.example.a07_05_lab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val galleryButton = findViewById<Button>(R.id.galleryButton)
        val soundPanelButton = findViewById<Button>(R.id.soundPanelButton)

        galleryButton.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

        soundPanelButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}