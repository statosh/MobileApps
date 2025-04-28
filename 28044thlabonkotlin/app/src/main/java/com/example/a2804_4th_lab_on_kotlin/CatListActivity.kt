package com.example.a2804_4th_lab_on_kotlin

import android.database.Cursor
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity

class CatListActivity : AppCompatActivity() {

    private lateinit var dbHelper: CatDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_list)

        dbHelper = CatDatabaseHelper(this)
        val listView = findViewById<ListView>(R.id.listViewCats)

        val cursor: Cursor = dbHelper.getAllCats()
        val from = arrayOf("name", "timestamp", "breed", "color")
        val to = intArrayOf(R.id.textViewName, R.id.textViewTimestamp, R.id.textViewField1, R.id.textViewField2)

        val adapter = SimpleCursorAdapter(
            this,
            R.layout.list_item_cat,
            cursor,
            from,
            to,
            0
        )
        listView.adapter = adapter
    }
}