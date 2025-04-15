package com.example.a1404;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testDivisionByZero() {
        calculator.appendNumber("123");
        calculator.setOperation("/");
        calculator.appendNumber("0");

        assertEquals("Error", calculator.calculateResult());
    }

    @Test
    public void testAddition() {
        calculator.appendNumber("12");
        calculator.setOperation("+");
        calculator.appendNumber("60");

        assertEquals("72", calculator.calculateResult());
    }

}
