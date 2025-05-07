package com.example.a07_05_lab

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var buttonSound1: Button
    private lateinit var buttonSound2: Button
    private lateinit var buttonSound3: Button
    private lateinit var buttonSound4: Button
    private lateinit var buttonSound5: Button
    private lateinit var textViewSoundName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        buttonSound1 = findViewById<Button>(R.id.buttonSound1)
        buttonSound2 = findViewById<Button>(R.id.buttonSound2)
        buttonSound3 = findViewById<Button>(R.id.buttonSound3)
        buttonSound4 = findViewById<Button>(R.id.buttonSound4)
        buttonSound5 = findViewById<Button>(R.id.buttonSound5)
        textViewSoundName = findViewById<TextView>(R.id.textViewSoundName)

        buttonSound1.setOnClickListener {
            playSound(R.raw.sound1)
            textViewSoundName.text = "sound1.wav"
        }

        buttonSound2.setOnClickListener {
            playSound(R.raw.sound2)
            textViewSoundName.text = "sound2.wav"
        }

        buttonSound3.setOnClickListener {
            playSound(R.raw.sound3)
            textViewSoundName.text = "sound3.wav"
        }

        buttonSound4.setOnClickListener {
            playSound(R.raw.sound4)
            textViewSoundName.text = "sound4.wav"
        }

        buttonSound5.setOnClickListener {
            playSound(R.raw.sound5)
            textViewSoundName.text = "sound5.mp3"
        }
    }

    private fun playSound(soundResId: Int) {
        val mediaPlayer = MediaPlayer.create(this, soundResId)
        mediaPlayer.start()
        mediaPlayer.setOnCompletionListener { it.release() }
    }
}