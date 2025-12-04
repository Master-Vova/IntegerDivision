package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FormatterTests {
    @Test
    public void testNumberDivision1() {
        int[][] arr = {{1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {1, 18, 52, 3, 30, 40, 10, 100, 90, 122},
                {0, 13, 52, 13, 26, 39, 13, 91, 78, 117}};
        DivisionResult data = new DivisionResult(1823000002, 13, arr, 5);
        String expected = """
                _1823000002│13
                 13        │---------
                 --        │140230769
                 _52
                  52
                  --
                   _30
                    26
                    --
                    _40
                     39
                     --
                     _100
                       91
                       --
                       _90
                        78
                        --
                       _122
                        117
                        ---
                          5""";
        DivisionFormatter formatter = new DivisionFormatter();
        assertEquals(expected, formatter.formatResult(data));
    }

    @Test
    public void testZeroReminder() {
        int[][] arr = {{1, 0, 0, 0}, {1, 10, 20, 40}, {0, 8, 16, 40}};
        DivisionResult data = new DivisionResult(1000, 8, arr, 0);
        String expected = """
                _1000│8
                  8  │---
                  -  │125
                 _20
                  16
                  --
                  _40
                   40
                   --
                    0""";

        DivisionFormatter formatter = new DivisionFormatter();
        assertEquals(expected, formatter.formatResult(data));
    }

    @Test
    public void testNumberDivision3() {
        int[][] arr = {{1, 1, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 18, 182, 493, 940, 90, 900, 1020, 890, 922},
                {0, 133, 133, 399, 931, 133, 798, 931, 798, 798}};
        DivisionResult data = new DivisionResult(1823000002, 133, arr, 124);
        String expected = """
                _1823000002│133
                 133       │--------
                 ---       │13706766
                 _493
                  399
                  ---
                  _940
                   931
                   ---
                    _900
                     798
                     ---
                    _1020
                      931
                      ---
                      _890
                       798
                       ---
                       _922
                        798
                        ---
                        124""";
        DivisionFormatter formatter = new DivisionFormatter();
        assertEquals(expected, formatter.formatResult(data));
    }

    @Test
    public void testNumber14823DevidedBy3() {

        int[][] arr = {{1, 0, 0, 0, 0}, {1, 14, 28, 12, 3}, {0, 12, 27, 12, 3}};
        DivisionResult data = new DivisionResult(14823, 3, arr, 0);
        String expected = """
                _14823│3
                 12   │----
                 --   │4941
                 _28
                  27
                  --
                  _12
                   12
                   --
                    _3
                     3
                     -
                     0""";
        DivisionFormatter formatter = new DivisionFormatter();
        assertEquals(expected, formatter.formatResult(data));
    }

    @Test
    public void testMaxValueDividend() {
        int[][] arr = {{1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                {2, 21, 214, 2147, 21474, 214748, 480833, 363936, 306064, 282897},
                {0, 55555, 55555, 55555, 55555, 166665, 444440, 333330, 277775, 277775}};
        DivisionResult data = new DivisionResult(2147483647, 55555, arr, 5122);
        String expected = """
                _2147483647│55555
                 166665    │-----
                 ------    │38655
                 _480833
                  444440
                  ------
                  _363936
                   333330
                   ------
                   _306064
                    277775
                    ------
                    _282897
                     277775
                     ------
                       5122""";

        DivisionFormatter formatter = new DivisionFormatter();
        assertEquals(expected, formatter.formatResult(data));
    }

    @Test
    public void testForNegativeInput() {
        String expected = "-14823 value of dividend is less than zero isn't allowed...";
        int[][] arr = {{1, 0, 0, 0}, {1, 10, 20, 40}, {0, 8, 16, 40}};
        DivisionResult data = new DivisionResult(-14823, 3, arr, 0);
        DivisionFormatter formatter = new DivisionFormatter();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                formatter.formatResult(data));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testDividingByZero() {
        String expected = "Dividing by zero isn't allowed";
        int[][] arr = {{1, 0, 0, 0}, {1, 10, 20, 40}, {0, 8, 16, 40}};
        DivisionResult data = new DivisionResult(14823, 0, arr, 0);

        DivisionFormatter formatter = new DivisionFormatter();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                formatter.formatResult(data));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testDivisorGreaterThanDividend() {
        String expected = "Dividend is less than divisor...";
        int[][] arr = {{1, 0, 0, 0}, {1, 10, 20, 40}, {0, 8, 16, 40}};
        DivisionResult data = new DivisionResult(14823, 20000, arr, 0);

        DivisionFormatter formatter = new DivisionFormatter();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                formatter.formatResult(data));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testNullArray() {
        DivisionResult data = new DivisionResult(1000, 8, null, 0);
        DivisionFormatter formatter = new DivisionFormatter();
        String expected = "Formatter got empty array";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                formatter.formatResult(data));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testArrayLength() {
        int[][] arr = {{1, 0, 0, 0}, {1, 10, 20, 40}, {0, 8, 16, 40}};
        DivisionResult data = new DivisionResult(1000, 8, arr, 0);
        DivisionFormatter formatter = new DivisionFormatter();
        String expected = "Something wrong with array length";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                formatter.formatResult(data));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testNegativeValueInArray() {
        int[][] arr = {{1, 0, 0, 0}, {1, 10, 20, -40}, {0, 8, 16, 40}};
        DivisionResult data = new DivisionResult(1000, 8, arr, 0);
        DivisionFormatter formatter = new DivisionFormatter();
        String expected = "Array has negative value";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                formatter.formatResult(data));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testNegativeRemainder() {
        int[][] arr = {{1, 0, 0, 0}, {1, 10, 20, 40}, {0, 8, 16, 40}};
        DivisionResult data = new DivisionResult(1000, 8, arr, -5);
        DivisionFormatter formatter = new DivisionFormatter();
        String expected = "Remainder is negative, its shouldn't be possible";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                formatter.formatResult(data));
        assertEquals(expected, exception.getMessage());
    }
}
