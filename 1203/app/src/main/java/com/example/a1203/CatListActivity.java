package com.example.a1203;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class CatListActivity extends AppCompatActivity {
    private CatDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_list);

        dbHelper = new CatDatabaseHelper(this);
        ListView listView = findViewById(R.id.listViewCats);

        Cursor cursor = dbHelper.getAllCats();
        String[] from = {"name", "timestamp", "breed", "color"};
        int[] to = {R.id.textViewName, R.id.textViewTimestamp, R.id.textViewField1, R.id.textViewField2};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this, R.layout.list_item_cat, cursor, from, to, 0);
        listView.setAdapter(adapter);
    }
}
