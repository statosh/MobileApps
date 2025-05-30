package com.example.a30_05

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class SwitchActivity : AppCompatActivity() {

    private lateinit var redSwitch: Switch
    private lateinit var greenSwitch: Switch
    private lateinit var blueSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch)

        redSwitch = findViewById(R.id.redSwitch)
        greenSwitch = findViewById(R.id.greenSwitch)
        blueSwitch = findViewById(R.id.blueSwitch)

        val rootView = findViewById<View>(R.id.rootView)

        val listener = CompoundButton.OnCheckedChangeListener { _, _ ->
            updateBackgroundColor()
        }

        redSwitch.setOnCheckedChangeListener(listener)
        greenSwitch.setOnCheckedChangeListener(listener)
        blueSwitch.setOnCheckedChangeListener(listener)
    }

    private fun updateBackgroundColor() {
        var color = 0x000000 // Черный (по умолчанию)

        if (redSwitch.isChecked) color = color or Color.RED
        if (greenSwitch.isChecked) color = color or Color.GREEN
        if (blueSwitch.isChecked) color = color or Color.BLUE

        // Если все три включены — белый
        if (redSwitch.isChecked && greenSwitch.isChecked && blueSwitch.isChecked) {
            color = Color.WHITE
        }

        findViewById<View>(R.id.rootView).setBackgroundColor(color)
    }
}