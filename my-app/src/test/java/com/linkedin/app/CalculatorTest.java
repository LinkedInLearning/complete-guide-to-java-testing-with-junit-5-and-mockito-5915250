package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void add() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void subtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    public void multiply() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    public void divide() {
        assertEquals(2.0, calculator.divide(4, 2));
    }

    @Test
    void divideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(4, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}