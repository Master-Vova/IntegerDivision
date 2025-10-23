package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DivisionProcessorTest {
    @Test
    public void testNumber1823000002DevidedBy13() {
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
        IntegerDivision IntegerDivision = new IntegerDivision();
        assertEquals(expected, IntegerDivision.buildLongDivisionVisualization(1823000002, 13));
    }

    @Test
    public void testNumber1000DevidedBy8() {
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
        IntegerDivision IntegerDivision = new IntegerDivision();
        assertEquals(expected, IntegerDivision.buildLongDivisionVisualization(1000, 8));
    }

    @Test
    public void testNumber1823000002DevidedBy133() {
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
        IntegerDivision IntegerDivision = new IntegerDivision();
        assertEquals(expected, IntegerDivision.buildLongDivisionVisualization(1823000002, 133));
    }

    @Test
    public void testNumber14823DevidedBy3() {
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
        IntegerDivision IntegerDivision = new IntegerDivision();
        assertEquals(expected, IntegerDivision.buildLongDivisionVisualization(14823, 3));
    }

    @Test
    public void testMaxValueDividend() {
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
        IntegerDivision IntegerDivision = new IntegerDivision();
        assertEquals(expected, IntegerDivision.buildLongDivisionVisualization((Integer.MAX_VALUE), 55555));
    }

    @Test
    public void testForNegativeInput() {
        String expected = "-14823 value isn't allowed...";
        IntegerDivision IntegerDivision = new IntegerDivision();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                IntegerDivision.buildLongDivisionVisualization(-14823, 3));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testDividingByZero() {
        String expected = "Dividing by zero isn't allowed";
        IntegerDivision IntegerDivision = new IntegerDivision();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                IntegerDivision.buildLongDivisionVisualization(14823, 0));
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void testDivisorGreaterThanDividend() {
        String expected = "Dividend is less than divisor...";
        IntegerDivision IntegerDivision = new IntegerDivision();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                IntegerDivision.buildLongDivisionVisualization(14823, 20000));
        assertEquals(expected, exception.getMessage());
    }
}