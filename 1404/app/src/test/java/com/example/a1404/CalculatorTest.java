package com.example.a1404;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testIncorrectOperation() {
        calculator.appendNumber("250");
        calculator.setOperation("A");
        calculator.appendNumber("125");
        assertEquals("Error", calculator.calculateResult());
    }

    @Test
    public void testIncorrectNumber() {
        calculator.appendNumber("ert");
        calculator.setOperation("-");
        calculator.appendNumber("125");
        assertEquals("Error", calculator.calculateResult());
    }

    @Test
    public void testAddition() {
        calculator.appendNumber("10");
        calculator.setOperation("+");
        calculator.appendNumber("20");
        assertEquals("30.0", calculator.calculateResult());
    }

    @Test
    public void testDivisionByZero() {
        calculator.appendNumber("10");
        calculator.setOperation("/");
        calculator.appendNumber("0");
        assertEquals("Error", calculator.calculateResult());
    }
}