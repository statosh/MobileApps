package com.example.a18_06

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first)

        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {
            Toast.makeText(this, "КНОПКАААААААААА ОДИН", Toast.LENGTH_SHORT).show()
        }

        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            Toast.makeText(this, "КНОПКАААААААААА ДВАА", Toast.LENGTH_SHORT).show()
        }

    }
}