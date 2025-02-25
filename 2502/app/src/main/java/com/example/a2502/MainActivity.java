package com.example.a2502;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText minValueEditText;
    private EditText maxValueEditText;
    private Button generateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minValueEditText = findViewById(R.id.minValue);
        maxValueEditText = findViewById(R.id.maxValue);
        generateButton = findViewById(R.id.generateButton);
        resultTextView = findViewById(R.id.resultTextView);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumber();
            }
        });
    }

    private void generateRandomNumber() {
        String minValueStr = minValueEditText.getText().toString();
        String maxValueStr = maxValueEditText.getText().toString();

        if (minValueStr.isEmpty() || maxValueStr.isEmpty()) {
            Toast.makeText(this, "Пожалуйста, введите диапазон!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int minValue = Integer.parseInt(minValueStr);
            int maxValue = Integer.parseInt(maxValueStr);

            if (minValue >= maxValue) {
                Toast.makeText(this, "Минимальное значение должно быть меньше максимального!", Toast.LENGTH_SHORT).show();
                return;
            }

            Random random = new Random();
            int randomNumber = random.nextInt(maxValue - minValue + 1) + minValue;
            resultTextView.setText("Случайное число: " + randomNumber);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Введите корректные числа!", Toast.LENGTH_SHORT).show();
        }
    }
}