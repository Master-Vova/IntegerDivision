package org.example;

final public class DigitsUtil {
    private DigitsUtil() {
    }

    public static int getDigitFromNumber(int dividend, int i) {
        validate(dividend, i);

        int result = (int) (dividend / (Math.pow(10, getNumberLength(dividend) - i - 1)));
        if (result >= 10) {
            result = result % 10;
        }
        return result;
    }

    public static int getNumberLength(int number) {
        validate(number);
        return Integer.toString(number).length();
    }

     public static boolean lengthItDifferent(int dividend, int divisor) {
        validate(dividend, divisor);
        return getNumberLength(dividend) > getNumberLength(divisor);
    }

    private static void validate(int... numbers) {
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("Number " + number + " is negative, " +
                        "which is not allowed in current program");
            }
        }
    }

}
