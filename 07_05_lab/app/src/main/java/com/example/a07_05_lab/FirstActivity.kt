package com.example.a07_05_lab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class FirstActivity : AppCompatActivity() {

    private var image1State = true
    private var image2State = true
    private var image3State = true
    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var imageView3: ImageView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        imageView1 = findViewById<ImageView>(R.id.imageView1)
        imageView2 = findViewById<ImageView>(R.id.imageView2)
        imageView3 = findViewById<ImageView>(R.id.imageView3)

        button1 = findViewById<Button>(R.id.button1)
        button2 = findViewById<Button>(R.id.button2)
        button3 = findViewById<Button>(R.id.button3)

        button1.setOnClickListener {
            if (image1State) {
                imageView1.setImageResource(R.drawable.image2)
            } else {
                imageView1.setImageResource(R.drawable.image1)
            }
            image1State = !image1State
        }

        button2.setOnClickListener {
            if (image2State) {
                imageView2.setImageResource(R.drawable.image4)
            } else {
                imageView2.setImageResource(R.drawable.image3)
            }
            image2State = !image2State
        }

        button3.setOnClickListener {
            if (image3State) {
                imageView3.setImageResource(R.drawable.image6)
            } else {
                imageView3.setImageResource(R.drawable.image5)
            }
            image3State = !image3State
        }
    }
}