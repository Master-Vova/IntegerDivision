package org.example;

class StringConstuctor {
    private StringConstuctor() {
    }

    protected static String firstWriteString(int initialDividend, int initialDivisor,
                                             int changingDividend, int changingDivisor) {

        int quotient = initialDividend / initialDivisor;
        int dif = checkIfNumberLengthHasDifference(changingDividend, changingDivisor);
        String spaceAfter = " ".repeat(numberLength(initialDividend) - dif - numberLength(changingDivisor));
        String spaceBefore = " ".repeat(dif + 1);

        String line1 = String.format("_%d│%d\n", initialDividend, initialDivisor);
        String line2 = String.format("%s%d%s│%s\n", spaceBefore, changingDivisor, spaceAfter,
                "-".repeat(numberLength(quotient)));
        String line3 = String.format("%s%s%s│%d\n", spaceBefore, "-".repeat(numberLength(changingDivisor)),
                spaceAfter, quotient);

        return line1 + line2 + line3;
    }

    protected static String writingString(int dividend, int divisor, int i) {

        int x = i - numberLength(dividend) + 2;
        int dif = checkIfNumberLengthHasDifference(dividend, divisor);

        String line1 = String.format("%s_%s\n", " ".repeat(x - 1), dividend);
        String line2 = String.format("%s%s\n", " ".repeat(x + dif), divisor);
        String line3 = String.format("%s%s\n", " ".repeat(x + dif), "-".repeat(numberLength(divisor)));

        return line1 + line2 + line3;
    }

    private static int numberLength(int dividend) {
        return CalculationMethodsHelper.numberLength(dividend);
    }

    private static int checkIfNumberLengthHasDifference(int dividend, int divisor) {
        return CalculationMethodsHelper.checkIfNumberLengthHasDifference(dividend, divisor);
    }

}
