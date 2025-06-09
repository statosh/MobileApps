package com.example.a09_06

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {
    override fun onCreate(saved: Bundle?) {
        super.onCreate(saved)
        setContentView(R.layout.activity_second)

        findViewById<Button>(R.id.btnToThirdActivity).setOnClickListener {
            val text = findViewById<EditText>(R.id.etSecond).text.toString().trim()
            if (text.isEmpty()) {
                Toast.makeText(this, "Введите текст", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            startActivity(Intent(this, ThirdActivity::class.java).apply {
                putExtra("text", text)
            })
        }
    }
}
