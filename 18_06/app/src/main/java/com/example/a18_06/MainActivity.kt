package com.example.a18_06

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer1: MediaPlayer
    private lateinit var mediaPlayer2: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        mediaPlayer1 = MediaPlayer.create(this, R.raw.sound1)
        mediaPlayer2 = MediaPlayer.create(this, R.raw.sound2)

        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {
            mediaPlayer1.start()
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            mediaPlayer2.start()
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
}