package org.example;

public class IntegerDivision {

    public String performDivision(int dividend, int divisor) {

        validate(dividend, divisor);
        DivisionFormatter formatter = new DivisionFormatter(dividend, divisor);
        int digitsChecked = 0;
        int reminder = 0;

        while (digitsChecked < DigitsUtil.getNumberLength(dividend)) {

            int changingDividend = (reminder * 10) + DigitsUtil.getDigitFromNumber(dividend, digitsChecked);
            int changingDivisor = (changingDividend / divisor) * divisor;
            reminder = changingDividend % divisor;

            if (changingDividend < divisor) {
                digitsChecked++;
                continue;
            }
            formatter.writeString(changingDividend, changingDivisor, digitsChecked);
            digitsChecked++;
        }
        formatter.writeLastLine(reminder);

        return formatter.result.toString();
    }

    private static void validate(int dividend, int divisor) {
        if (dividend < 0 || divisor < 0) {
            throw new IllegalArgumentException("Calculation with negative numbers is still developing... " +
                    "Sorry for the inconveniences");
        } else if (divisor == 0) {
            throw new IllegalArgumentException("Dividing by zero isn't allowed");
        } else if (dividend < divisor) {
            throw new IllegalArgumentException("Dividend is less than divisor...");
        }
    }
}
