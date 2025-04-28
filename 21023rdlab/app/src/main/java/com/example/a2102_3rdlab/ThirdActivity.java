package com.example.a2102_3rdlab;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

public class ThirdActivity extends Activity {
    private boolean isGreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button button = findViewById(R.id.buttonChangeColor);
        button.setOnClickListener(v -> {
            button.setBackgroundColor(Color.parseColor("#90EE90"));
            isGreen = true;

            new Handler().postDelayed(() -> {
                if (isGreen) {
                    button.setBackgroundResource(R.drawable.button_border);
                    isGreen = false;
                }
            }, 2000);
        });
    }
}
