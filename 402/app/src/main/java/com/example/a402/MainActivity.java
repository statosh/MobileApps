package com.example.a402;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(android.R.id.content);

        Button buttonYellow = findViewById(R.id.buttonYellow);
        Button buttonBlue = findViewById(R.id.buttonBlue);
        Button buttonRed = findViewById(R.id.buttonRed);
        Button buttonGreen = findViewById(R.id.buttonGreen);

        buttonYellow.setOnClickListener(v -> changeBackgroundColor(Color.YELLOW));
        buttonBlue.setOnClickListener(v -> changeBackgroundColor(Color.BLUE));
        buttonRed.setOnClickListener(v -> changeBackgroundColor(Color.RED));
        buttonGreen.setOnClickListener(v -> changeBackgroundColor(Color.GREEN));
    }

    private void changeBackgroundColor(int color) {
        rootView.setBackgroundColor(color);
    }
}