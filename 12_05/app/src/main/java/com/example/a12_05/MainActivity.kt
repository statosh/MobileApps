package com.example.a12_05

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToastExamples = findViewById<Button>(R.id.btnToastExamples)
        val btnPopupExamples = findViewById<Button>(R.id.btnPopupExamples)

        btnToastExamples.setOnClickListener {
            startActivity(Intent(this, ToastActivity::class.java))
        }

        btnPopupExamples.setOnClickListener {
            startActivity(Intent(this, PopupActivity::class.java))
        }
    }
}