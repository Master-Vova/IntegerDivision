package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivisionProcessUtilTest {

    @Test
    public void testNumber1823000002DevidedBy13() {
        String expected = "_1823000002│13\n" +
                " 13        │---------\n" +
                " --        │140230769\n" +
                " _52\n" +
                "  52\n" +
                "  --\n" +
                "   _30\n" +
                "    26\n" +
                "    --\n" +
                "    _40\n" +
                "     39\n" +
                "     --\n" +
                "     _100\n" +
                "       91\n" +
                "       --\n" +
                "       _90\n" +
                "        78\n" +
                "        --\n" +
                "       _122\n" +
                "        117\n" +
                "        ---\n" +
                "          5";
        assertEquals(expected, DivisionProcessUtil.process(1823000002, 13));
    }

    @Test
    public void testNumber1000DevidedBy8() {
        String expected = "_1000│8\n" +
                "  8  │---\n" +
                " --  │125\n" +
                " _20\n" +
                "  16\n" +
                "  --\n" +
                "  _40\n" +
                "   40\n" +
                "   --\n" +
                "    0";
        assertEquals(expected, DivisionProcessUtil.process(1000, 8));
    }

    @Test
    public void testNumber1823000002DevidedBy133() {
        String expected = "_1823000002│133\n" +
                " 133       │--------\n" +
                " --        │13706766\n" +
                " _493\n" +
                "  399\n" +
                "  ---\n" +
                "  _940\n" +
                "   931\n" +
                "   ---\n" +
                "    _900\n" +
                "     798\n" +
                "     ---\n" +
                "    _1020\n" +
                "      931\n" +
                "      ---\n" +
                "      _890\n" +
                "       798\n" +
                "       ---\n" +
                "       _922\n" +
                "        798\n" +
                "        ---\n" +
                "        124";
        assertEquals(expected, DivisionProcessUtil.process(1823000002, 133));
    }

    @Test
    public void testNumber14823DevidedBy3() {
        String expected = "_14823│3\n" +
                " 12   │----\n" +
                " --   │4941\n" +
                " _28\n" +
                "  27\n" +
                "  --\n" +
                "  _12\n" +
                "   12\n" +
                "   --\n" +
                "    _3\n" +
                "     3\n" +
                "     -\n" +
                "     0";
        assertEquals(expected, DivisionProcessUtil.process(14823, 3));
    }
}