package org.example;

public class IntegerDivision {

    public String buildLongDivisionVisualization(int dividend, int divisor) {

        validate(dividend, divisor);

        DivisionFormatter formatter = new DivisionFormatter(dividend, divisor);
        Calculation calculation = new Calculation();

        int digitsChecked = 0;

        while (digitsChecked < DigitsUtil.getNumberLength(dividend)) {

            calculation.performDivision(divisor, DigitsUtil.getDigitFromNumber(dividend, digitsChecked));

            if (calculation.changingDividend < divisor) {
                digitsChecked++;
                continue;
            }
            formatter.writeString(calculation.changingDividend, calculation.changingDivisor, digitsChecked);
            digitsChecked++;
        }
        formatter.writeLastLine(calculation.reminder);

        return formatter.result.toString();
    }

    private static void validate(int dividend, int divisor) {
        if (dividend < 0) {
            throw new IllegalArgumentException("Negative dividend isn't allowed...");
        } else if (divisor < 0) {
            throw new IllegalArgumentException("Negative divisor isn't allowed...");
        } else if (divisor == 0) {
            throw new IllegalArgumentException("Dividing by zero isn't allowed");
        } else if (dividend < divisor) {
            throw new IllegalArgumentException("Dividend is less than divisor...");
        }
    }
}
