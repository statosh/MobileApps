package com.example.a2503;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText titleEditText, genreEditText, yearEditText, searchEditText;
    private MaterialButton addButton, searchButton;
    private MaterialTextView searchResultTextView;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleEditText = findViewById(R.id.titleEditText);
        genreEditText = findViewById(R.id.genreEditText);
        yearEditText = findViewById(R.id.yearEditText);
        searchEditText = findViewById(R.id.searchEditText);
        addButton = findViewById(R.id.addButton);
        searchButton = findViewById(R.id.searchButton);
        searchResultTextView = findViewById(R.id.searchResultTextView);

        dbHelper = new DatabaseHelper(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString().trim();
                String genre = genreEditText.getText().toString().trim();
                String yearStr = yearEditText.getText().toString().trim();

                if (title.isEmpty() || genre.isEmpty() || yearStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                    return;
                }

                int year;
                try {
                    year = Integer.parseInt(yearStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Введите год корректно", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean success = dbHelper.addMovie(title, genre, year);
                if (success) {
                    Toast.makeText(MainActivity.this, "Фильм успешно добавлен", Toast.LENGTH_SHORT).show();
                    titleEditText.setText("");
                    genreEditText.setText("");
                    yearEditText.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Не удалось добавить фильм", Toast.LENGTH_SHORT).show();
                }
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTitle = searchEditText.getText().toString().trim();
                if (searchTitle.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Введите имя фильма для поиска", Toast.LENGTH_SHORT).show();
                    return;
                }

                String result = dbHelper.searchMovie(searchTitle);
                searchResultTextView.setText(result);
            }
        });
    }
}