package com.example.a12_05

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PopupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)

        val btnSimplePopup = findViewById<Button>(R.id.btnSimplePopup)
        val btnActionPopup = findViewById<Button>(R.id.btnActionPopup)
        val btnCustomPopup = findViewById<Button>(R.id.btnCustomPopup)

        btnSimplePopup.setOnClickListener { view ->
            val textView = TextView(this).apply {
                text = "Это простой Popup!"
                setPadding(24, 24, 24, 24)
                background = getDrawable(android.R.drawable.dialog_holo_light_frame)
            }

            val popup = PopupWindow(textView, 600, 400, true).apply {
                isOutsideTouchable = true
                showAsDropDown(view, 0, 0)
            }

            Handler(mainLooper).postDelayed({
                if (popup.isShowing) popup.dismiss()
            }, 2000)
        }

        btnActionPopup.setOnClickListener { anchor ->
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.popup_action, null)

            val popup = PopupWindow(popupView, 700, 500, true).apply {
                setBackgroundDrawable(ColorDrawable(Color.WHITE))
                isOutsideTouchable = true
                showAsDropDown(anchor, 0, 0)
            }

            popupView.findViewById<Button>(R.id.btnYes).setOnClickListener {
                println("Пользователь нажал 'Да'")
                popup.dismiss()
            }

            popupView.findViewById<Button>(R.id.btnNo).setOnClickListener {
                println("Пользователь нажал 'Нет'")
                popup.dismiss()
            }
        }

        btnCustomPopup.setOnClickListener { anchor ->
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.activity_custom_popup, null)

            val popup = PopupWindow(popupView, 800, 800, true).apply {
                setBackgroundDrawable(getDrawable(R.drawable.rounded_popup_background))
                isOutsideTouchable = true
                showAtLocation(anchor, Gravity.CENTER, 0, 0)
            }

            popupView.findViewById<Button>(R.id.btnClosePopup).setOnClickListener {
                popup.dismiss()
            }
        }
    }
}