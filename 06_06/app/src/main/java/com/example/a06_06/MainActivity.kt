package com.example.a06_06

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var isFirstFragment = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Устанавливаем первый фрагмент по умолчанию
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, FirstFragment())
            .commit()

        val switchFragmentButton: Button = findViewById(R.id.switchFragmentButton)
        val goToSecondActivityButton: Button = findViewById(R.id.goToSecondActivityButton)

        switchFragmentButton.setOnClickListener {
            if (isFirstFragment) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, SecondFragment())
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, FirstFragment())
                    .commit()
            }
            isFirstFragment = !isFirstFragment
        }

        goToSecondActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}