package com.example.testing.testingexample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Calculator test class
 * Created by Even on 1/4/16.
 */
public class CalculatorTest {
    private Calculator mCalculator;

    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(6d, mCalculator.sum(1d, 5d), 0);
    }

    @Test
    public void testSubtract() throws Exception {
        assertEquals(1d, mCalculator.subtract(5d, 4d), 0);
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(4d, mCalculator.divide(20d, 5d), 0);
    }

    @Test
    public void testMultiply() throws Exception {
        assertEquals(10d, mCalculator.multiply(2d, 5d), 0);
    }
}