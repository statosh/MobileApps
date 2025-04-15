package com.example.a1404;

public class Calculator {

    private String currentNumber = "";
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String curOperation = "";
    private boolean isNewOperation = true;
    private double result;

    public void appendNumber(String number) {
        if (isNewOperation) {
            currentNumber = "";
            isNewOperation = false;
        }
        currentNumber += number;
    }

    public void setOperation(String operation) {
        if (!(currentNumber.isEmpty())) {
            firstNumber = Double.parseDouble(currentNumber);
            curOperation = operation;
            currentNumber = "";
        }
    }

    public String calculateResult() {
        if (!(curOperation.isEmpty()) && !(currentNumber.isEmpty()) && firstNumber != 0) {
            secondNumber = Double.parseDouble(currentNumber);
            switch (curOperation) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber == 0) { return "Error"; }
                    result = firstNumber / secondNumber;
                    break;
            }
            curOperation = "";
            isNewOperation = true;
            currentNumber = String.valueOf(result);
            return currentNumber;
        }
        return currentNumber.isEmpty() ? "0" : currentNumber;
    }
    public String getCurrentNumber() {
        return currentNumber.isEmpty() ? "0" : currentNumber;
    }
    public void clear() {
        currentNumber = "";
        curOperation = "";
        firstNumber = 0;
        secondNumber = 0;
        result = 0;
        isNewOperation = true;
    }
}