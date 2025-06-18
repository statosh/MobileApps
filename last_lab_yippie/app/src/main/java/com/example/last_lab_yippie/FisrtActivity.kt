package com.example.last_lab_yippie

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FisrtActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fisrt)

        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {
            Toast.makeText(this, "ЙА ТОСТ", Toast.LENGTH_SHORT).show()
        }

        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            Log.i("kfkfkfkfkfkfkfkf", "kfkfkfkfkfkfkfkf")
        }

    }
}