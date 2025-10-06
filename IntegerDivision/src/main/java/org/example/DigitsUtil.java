package org.example;

class DigitsUtil {
    private DigitsUtil() {
    }

    static final int getDigitFromNumber(int dividend, int i) {
        validate(dividend);
        validate(i);

        int result = (int) (dividend / (Math.pow(10, getNumberLength(dividend) - i - 1)));
        if (result >= 10) {
            result = result % 10;
        }
        return result;
    }

     static final int getNumberLength(int number) {
        validate(number);

        String sample = Integer.toString(number);
        return sample.length();
    }

     static final boolean lengthItDifferent(int dividend, int divisor) {
        validate(dividend);
        validate(divisor);

        return getNumberLength(dividend) > getNumberLength(divisor);
    }

    private static void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Utility class got wrong input");
        }
    }

}
