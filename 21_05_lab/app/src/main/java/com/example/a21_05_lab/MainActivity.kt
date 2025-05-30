package com.example.a21_05_lab

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.button_sound)

        findViewById<Button>(R.id.btnDragDrop).setOnClickListener {
            playSound()
            startActivity(Intent(this, DragActivity::class.java))
        }

        findViewById<Button>(R.id.btnColorButton).setOnClickListener {
            playSound()
            startActivity(Intent(this, ColorButtonActivity::class.java))
        }
    }

    private fun playSound() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.seekTo(0)
        }
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}