package org.example;

public class IntegerDivision {
    public DivisionResult calculate(int initialDividend, int initialDivisor) {
        validate(initialDividend, initialDivisor);

        int changingDividend;
        int changingDivisor;
        int reminder = 0;

        int[][] arr = new int[3][DigitsUtil.getNumberLength(initialDividend)];
        int digitsChecked = 0;

        while (digitsChecked < DigitsUtil.getNumberLength(initialDividend)) {

            changingDividend = (reminder * 10) +
                    DigitsUtil.getDigitFromNumber(initialDividend, digitsChecked);
            changingDivisor = (changingDividend / initialDivisor) * initialDivisor;
            reminder = changingDividend % initialDivisor;

            arr[1][digitsChecked] = changingDividend;
            arr[2][digitsChecked] = changingDivisor;

            if (changingDividend < initialDivisor) {
                arr[0][digitsChecked] = 1;
            }
            digitsChecked++;
        }
        return new DivisionResult(initialDividend, initialDivisor, arr, reminder);
    }

    private void validate(int dividend, int divisor) {
        if (dividend < 0) {
            throw new IllegalArgumentException(dividend + " value of dividend is less than zero" +
                    " isn't allowed...");
        } else if (divisor < 0) {
            throw new IllegalArgumentException(divisor + " value of divisor is less than zero" +
                    " isn't allowed...");
        } else if (divisor == 0) {
            throw new IllegalArgumentException("Dividing by zero isn't allowed");
        } else if (dividend < divisor) {
            throw new IllegalArgumentException("Dividend is less than divisor...");
        }
    }
}
