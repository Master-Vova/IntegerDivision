package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DivisionProcessorTest {
    @Test
    public void testNumber1823000002DevidedBy13() {
        IntegerDivision integerDivision = new IntegerDivision();
        int[][] arr = {{1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {1, 18, 52, 3, 30, 40, 10, 100, 90, 122},
                {0, 13, 52, 0, 26, 39, 0, 91, 78, 117}};
        DivisionResult expected = new DivisionResult(1823000002,13, arr, 5);
        DivisionResult result = integerDivision.calculate(1823000002, 13);

        assertArrayEquals(expected.arr(), result.arr());
        assertEquals(expected.initialDividend(), result.initialDividend());
        assertEquals(expected.initialDivisor(), result.initialDivisor());
        assertEquals(expected.reminder(), result.reminder());
    }

    @Test
    public void testForNegativeInput() {
        String expected = "-14823 value of dividend is less than zero isn't allowed...";
        IntegerDivision integerDivision = new IntegerDivision();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                integerDivision.calculate(-14823, 3));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testDividingByZero() {
        String expected = "Dividing by zero isn't allowed";
        IntegerDivision IntegerDivision = new IntegerDivision();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                IntegerDivision.calculate(14823, 0));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testDivisorGreaterThanDividend() {
        String expected = "Dividend is less than divisor...";
        IntegerDivision IntegerDivision = new IntegerDivision();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                IntegerDivision.calculate(14823, 20000));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testForArrays() {
        int[][] expected = {{1, 0, 0, 0},{1, 10, 20, 40},{0, 8, 16, 40}};

        IntegerDivision integerDivision = new IntegerDivision();
        DivisionResult result = integerDivision.calculate(1000, 8);

        assertEquals(Arrays.deepToString(expected), Arrays.deepToString(result.arr()));
    }
}