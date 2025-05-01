package com.example.a1203;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CatDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "cats.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CATS = "cats";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_TIMESTAMP = "timestamp";
    private static final String COLUMN_BREED = "breed";
    private static final String COLUMN_COLOR = "color";

    public CatDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_CATS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_TIMESTAMP + " TEXT, " +
                COLUMN_BREED + " TEXT, " +
                COLUMN_COLOR + " TEXT);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATS);
        onCreate(db);
    }

    public void addCat(String name, String breed, String color) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, "Имя: " +name);
        values.put(COLUMN_TIMESTAMP, "Дата добавления: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        values.put(COLUMN_BREED, "Порода: " + breed);
        values.put(COLUMN_COLOR, "Цвет: " + color);
        db.insert(TABLE_CATS, null, values);
        db.close();
    }

    public Cursor getAllCats() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_CATS, null);
    }

    public void renameLastCat() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_CATS + " SET name = 'Имя: Сахарок' WHERE _id = (SELECT MAX(_id) FROM " + TABLE_CATS + ")");
        db.close();
    }

    public void deleteAllAndAddDefaultCats() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_CATS);
        for (int i = 1; i <= 5; i++) {
            addCat("Кошка " + i, "Порода " + i, "Цвет " + i);
        }
        db.close();
    }
}
