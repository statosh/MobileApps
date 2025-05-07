package com.example.a07_05

import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var switchButton: Button
    private var isFirstImage = true
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchButton = findViewById<Button>(R.id.switchButton)
        imageView = findViewById<ImageView>(R.id.imageView)

        mediaPlayer = MediaPlayer.create(this, R.raw.sci_fi_click)

        switchButton.setOnClickListener {
            play()
            if (isFirstImage) {
                imageView.setImageResource(R.drawable.image2)
                isFirstImage = false
            } else {
                imageView.setImageResource(R.drawable.image1)
                isFirstImage = true
            }
        }
    }

    private fun play() {
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