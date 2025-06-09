package com.example.a06_06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportFragmentManager.beginTransaction()
            .replace(R.id.secondFragmentContainer, FirstFragment())
            .commit()
    }
}