package com.example.a2804_3rdlabonkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonFirst = findViewById<Button>(R.id.buttonFirst)
        val buttonSecond = findViewById<Button>(R.id.buttonSecond)
        val buttonThird = findViewById<Button>(R.id.buttonThird)
        val buttonExit = findViewById<Button>(R.id.buttonExit)

        buttonFirst.setOnClickListener { startActivity(Intent(this, FirstActivity::class.java)) }
        buttonSecond.setOnClickListener { startActivity(Intent(this, SecondActivity::class.java)) }
        buttonThird.setOnClickListener { startActivity(Intent(this, ThirdActivity::class.java)) }
        buttonExit.setOnClickListener { finish() }
    }
}