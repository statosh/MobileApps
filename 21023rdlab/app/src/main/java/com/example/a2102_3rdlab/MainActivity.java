package com.example.a2102_3rdlab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonFirst = findViewById(R.id.buttonFirst);
        Button buttonSecond = findViewById(R.id.buttonSecond);
        Button buttonThird = findViewById(R.id.buttonThird);
        Button buttonExit = findViewById(R.id.buttonExit);

        buttonFirst.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FirstActivity.class)));
        buttonSecond.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SecondActivity.class)));
        buttonThird.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ThirdActivity.class)));
        buttonExit.setOnClickListener(v -> finish());
    }
}
