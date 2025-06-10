package com.example.a1404;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        display.setText("0");
    }

    public void onNumberClick(android.view.View view) {
        Button button = (Button) view;
        String number = button.getText().toString();
        calculator.appendNumber(number);
        display.setText(getCurrentText());
    }

    public void onOperationClick(android.view.View view) {
        Button button = (Button) view;
        String op = button.getText().toString();
        calculator.setOperation(op);
        display.setText(calculator.getFirstNumber() + " " + op);
    }

    public void onEqualsClick(android.view.View view) {
        String result = calculator.calculateResult();
        display.setText(result);
    }

    public void onClearClick(android.view.View view) {
        calculator.reset();
        display.setText("0");
    }

    private String getCurrentText() {
        if (calculator.getOperation().isEmpty()) {
            return calculator.getFirstNumber();
        } else {
            return calculator.getFirstNumber() + " " + calculator.getOperation() + " " + calculator.getSecondNumber();
        }
    }
}