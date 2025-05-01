package com.example.a30_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

// Главный класс приложения, отвечающий за первый экран (MainActivity).
class MainActivity : AppCompatActivity() {

    // Объявление переменных для элементов интерфейса:
    private lateinit var inputField: EditText // Поле ввода текста
    private lateinit var sendButton: Button   // Кнопка отправки данных
    private lateinit var openButton: Button  // Кнопка открытия второго экрана без данных

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Установка макета activity_main.xml

        // Инициализация элементов интерфейса через findViewById
        inputField = findViewById(R.id.inputField) // Поле ввода текста
        sendButton = findViewById(R.id.sendButton) // Кнопка отправки данных
        openButton = findViewById(R.id.openButton) // Кнопка открытия второго экрана без данных

        // Обработка нажатия на кнопку "Отправить данные"
        sendButton.setOnClickListener {
            val text = inputField.text.toString() // Получение текста из поля ввода
            if (text.isNotEmpty()) { // Проверка, что поле не пустое
                val intent = Intent(this, SecondActivity::class.java) // Создание интента для перехода на второй экран
                intent.putExtra("DATA", text) // Добавление текста в интент как дополнительные данные
                startActivity(intent) // Запуск SecondActivity
            }
        }

        // Обработка нажатия на кнопку "Открыть без данных"
        openButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java) // Создание интента для перехода на второй экран
            startActivity(intent) // Запуск SecondActivity без передачи данных
        }
    }
}