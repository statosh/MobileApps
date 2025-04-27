package com.example.a2504

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val textView = findViewById<TextView>(R.id.textView)

        val text = intent.getStringExtra("text")
        textView.text = text
    }
}