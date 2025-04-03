package com.example.a1203;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName, editTextField1, editTextField2;
    private CatDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new CatDatabaseHelper(this);

        editTextName = findViewById(R.id.editTextName);
        editTextField1 = findViewById(R.id.editTextField1);
        editTextField2 = findViewById(R.id.editTextField2);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonView = findViewById(R.id.buttonView);
        Button buttonRename = findViewById(R.id.buttonRename);
        Button buttonDelete = findViewById(R.id.buttonDelete);

        buttonAdd.setOnClickListener(view -> {
            String name = editTextName.getText().toString();
            String field1 = editTextField1.getText().toString();
            String field2 = editTextField2.getText().toString();
            if (!name.isEmpty()) {
                dbHelper.addCat(name, field1, field2);
                Toast.makeText(this, "Добавлена кошечка: " + name, Toast.LENGTH_SHORT).show();
            }
        });

        buttonView.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CatListActivity.class);
            startActivity(intent);
        });

        buttonRename.setOnClickListener(view -> {
            dbHelper.renameLastCat();
            Toast.makeText(this, "Последняя кошечка переименована в 'Сахарок'", Toast.LENGTH_SHORT).show();
        });

        buttonDelete.setOnClickListener(view -> {
            dbHelper.deleteAllAndAddDefaultCats();
            Toast.makeText(this, "Удалены все записи. Добавлены 5 новых кошечек.", Toast.LENGTH_SHORT).show();
        });
    }
}
