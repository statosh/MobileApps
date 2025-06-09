package com.example.a09_06

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity: AppCompatActivity() {
    override fun onCreate(saved: Bundle?) {
        super.onCreate(saved)
        setContentView(R.layout.activity_third)
        val text = intent.getStringExtra("text") ?: ""
        findViewById<TextView>(R.id.tvResult).text = text
    }
}
