package com.example.a09_06

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {
    private var showingFirst = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.primaryFragmentContainer, FirstFragment.newInstance("Первый"))
            .commit()

        findViewById<Button>(R.id.btnToggleFragment).setOnClickListener {
            val fragment = if (showingFirst) {
                SecondFragment()
            } else {
                FirstFragment.newInstance("Второй")
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.primaryFragmentContainer, fragment)
                .commit()
            showingFirst = !showingFirst
        }

        findViewById<Button>(R.id.btnToSecondActivity).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}
