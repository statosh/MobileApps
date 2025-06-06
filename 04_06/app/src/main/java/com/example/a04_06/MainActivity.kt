package com.example.a04_06

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private var isOriginalOrder = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_1, FirstFragment())
            .replace(R.id.fragment_container_2, SecondFragment())
            .commit()

        val swapButton = findViewById<Button>(R.id.swapButton)
        swapButton.setOnClickListener {
            swapFragments()
        }
    }

    private fun swapFragments() {
        val first: Fragment = if (isOriginalOrder) SecondFragment() else FirstFragment()
        val second: Fragment = if (isOriginalOrder) FirstFragment() else SecondFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_1, first)
            .replace(R.id.fragment_container_2, second)
            .commit()

        isOriginalOrder = !isOriginalOrder
    }
}
