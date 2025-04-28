package com.example.a2804_4th_lab_on_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextField1: EditText
    private lateinit var editTextField2: EditText
    private lateinit var dbHelper: CatDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = CatDatabaseHelper(this)

        editTextName = findViewById(R.id.editTextName)
        editTextField1 = findViewById(R.id.editTextField1)
        editTextField2 = findViewById(R.id.editTextField2)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonView = findViewById<Button>(R.id.buttonView)
        val buttonRename = findViewById<Button>(R.id.buttonRename)
        val buttonDelete = findViewById<Button>(R.id.buttonDelete)

        buttonAdd.setOnClickListener {
            val name = editTextName.text.toString()
            val field1 = editTextField1.text.toString()
            val field2 = editTextField2.text.toString()

            if (name.isNotEmpty()) {
                dbHelper.addCat(name, field1, field2)
                Toast.makeText(this, "Добавлена кошечка: $name", Toast.LENGTH_SHORT).show()
            }
        }

        buttonView.setOnClickListener {
            startActivity(Intent(this, CatListActivity::class.java))
        }

        buttonRename.setOnClickListener {
            dbHelper.renameLastCat()
            Toast.makeText(this, "Последняя кошечка переименована в 'Сахарок'", Toast.LENGTH_SHORT).show()
        }

        buttonDelete.setOnClickListener {
            dbHelper.deleteAllAndAddDefaultCats()
            Toast.makeText(this, "Удалены все записи. Добавлены 5 новых кошечек.", Toast.LENGTH_SHORT).show()
        }
    }
}