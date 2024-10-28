package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

  private Calculator underTest = new Calculator();

  @Test
  public void addition() {
    int result = underTest.divide(2, 3);
    assertEquals(5, result, "Verify basic addition, result should be five");
  }

  @Test
  public void division() {
    int result = underTest.divide(6, 2);
    assertNotEquals(0, result, "Verify basic division, result should not be zero");
  }

  @Test
  public void isEven() {
    boolean result = underTest.isEven(4);
    assertTrue(result, "The number should be even");
  }

  @Test
  public void isEven_withOddNum() {
    boolean result = underTest.isEven(5);
    assertFalse(result, "The number should not be even");
  }

  // assertNull
  // assertNotNull
  @Test
  public void divideByZero() {
    Integer result = null;
    try {
      result = underTest.divide(6, 0);
    } catch (ArithmeticException e) {
      // Division by zero occurred
    }
    assertNull(result, "Division by zero should result in null");
  }

  @Test
  void divideNonZero() {
    Integer result = underTest.divide(10, 2);
    assertNotNull(result);
    assertEquals(5, result, "Verify basic division, result should be five");
  }
}