package com.example.a1404;

public class Calculator {
    private String firstNumber = "";
    private String secondNumber = "";
    private String operation = "";

    public void appendNumber(String number) {
        if (operation.isEmpty()) {
            firstNumber += number;
        } else {
            secondNumber += number;
        }
    }

    public void setOperation(String op) {
        operation = op;
    }

    public String calculateResult() {
        try {
            double num1 = Double.parseDouble(firstNumber);
            double num2 = Double.parseDouble(secondNumber);

            switch (operation) {
                case "+":
                    return String.valueOf(num1 + num2);
                case "-":
                    return String.valueOf(num1 - num2);
                case "*":
                    return String.valueOf(num1 * num2);
                case "/":
                    if (num2 == 0) return "Error";
                    return String.valueOf(num1 / num2);
                default:
                    return "Error";
            }
        } catch (NumberFormatException e) {
            return "Error";
        }
    }

    public void reset() {
        firstNumber = "";
        secondNumber = "";
        operation = "";
    }

    public String getFirstNumber() { return firstNumber; }
    public String getSecondNumber() { return secondNumber; }
    public String getOperation() { return operation; }
}