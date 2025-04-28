package com.example.a2804_4th_lab_on_kotlin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CatDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "cats.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_CATS = "cats"
        private const val COLUMN_ID = "_id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_TIMESTAMP = "timestamp"
        private const val COLUMN_BREED = "breed"
        private const val COLUMN_COLOR = "color"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_CATS (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NAME TEXT,
                $COLUMN_TIMESTAMP TEXT,
                $COLUMN_BREED TEXT,
                $COLUMN_COLOR TEXT
            );
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CATS")
        onCreate(db)
    }

    fun addCat(name: String, breed: String, color: String) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, "Имя: $name")
            put(COLUMN_TIMESTAMP, "Дата добавления: ${SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())}")
            put(COLUMN_BREED, "Порода: $breed")
            put(COLUMN_COLOR, "Цвет: $color")
        }
        db.insert(TABLE_CATS, null, values)
        db.close()
    }

    fun getAllCats(): Cursor {
        val db = readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_CATS", null)
    }

    fun renameLastCat() {
        val db = writableDatabase
        db.execSQL("UPDATE $TABLE_CATS SET $COLUMN_NAME = 'Имя: Сахарок' WHERE $COLUMN_ID = (SELECT MAX($COLUMN_ID) FROM $TABLE_CATS)")
        db.close()
    }

    fun deleteAllAndAddDefaultCats() {
        val db = writableDatabase
        db.execSQL("DELETE FROM $TABLE_CATS")
        for (i in 1..5) {
            addCat("Кошка $i", "Порода $i", "Цвет $i")
        }
        db.close()
    }
}