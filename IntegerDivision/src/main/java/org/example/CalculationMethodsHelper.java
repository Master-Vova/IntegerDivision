package org.example;

class CalculationMethodsHelper {
    protected static int takeDigitFromNumber(int dividend, int i) {
        int result = (int) (dividend / (Math.pow(10, numberLength(dividend) - i - 1)));
        if (result >= 10) {
            result = result % 10;
        }
        return result;
    }

    protected static int numberLength(int dividend) {
        String sample = Integer.toString(dividend);
        return sample.length();
    }

    protected static int checkIfNumberLengthHasDifference(int dividend, int divisor) {
        if (numberLength(dividend) > numberLength(divisor)) {
            return 1;
        }
        return 0;
    }

}
