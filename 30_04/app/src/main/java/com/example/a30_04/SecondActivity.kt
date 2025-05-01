package com.example.a30_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

// Второй экран приложения, отображающий полученные данные или сообщение об их отсутствии.
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second) // Установка макета activity_second.xml

        val textView = findViewById<TextView>(R.id.displayText) // Текстовое поле для отображения данных
        val receivedData = intent.getStringExtra("DATA") // Получение данных из интента по ключу "DATA"

        // Проверка, были ли переданы данные
        if (receivedData != null) {
            textView.text = "Получено: $receivedData" // Отображение полученных данных
        } else {
            textView.text = "Данные не переданы" // Сообщение о том, что данные не были переданы
        }
    }
}