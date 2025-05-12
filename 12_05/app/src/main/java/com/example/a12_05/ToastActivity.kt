package com.example.a12_05

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ToastActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        val btnSimpleToast = findViewById<Button>(R.id.btnSimpleToast)
        val btnToastWithSound = findViewById<Button>(R.id.btnToastWithSound)

        btnSimpleToast.setOnClickListener {
            Toast.makeText(this, "Это стандартный Toast!", Toast.LENGTH_SHORT).show()
        }

        btnToastWithSound.setOnClickListener {
            Toast.makeText(this, "Это стандартный Toast!", Toast.LENGTH_LONG).show()
            playSound()
        }
    }

    private fun playSound() {
        mediaPlayer = MediaPlayer.create(this, R.raw.sound_alert)
        mediaPlayer?.start()

        mediaPlayer?.setOnCompletionListener {
            mediaPlayer?.release()
        }
    }

    override fun onDestroy() {
        mediaPlayer?.release()
        super.onDestroy()
    }
}