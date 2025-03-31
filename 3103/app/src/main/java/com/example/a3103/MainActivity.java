package com.example.a3103;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonFirst = findViewById(R.id.button_first);
        Button buttonSecond = findViewById(R.id.button_second);
        Button buttonThird = findViewById(R.id.button_third);
        Button buttonFourth = findViewById(R.id.button_fourth);

        buttonFirst.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FirstActivity.class)));
        buttonSecond.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SecondActivity.class)));
        buttonThird.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ThirdActivity.class)));
        buttonFourth.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FourthActivity.class)));
    }
}