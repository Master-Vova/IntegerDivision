package org.example;

public class DivisionProcessor {
    private DivisionProcessor() {
    }

    public static String process(int dividend, int divisor) {

        inputCheck(dividend, divisor);

        int digitsChecked = 0;
        int reminder = 0;
        String visualResult = "";

        while (digitsChecked < numberLength(dividend)) {

            int changingDividend = (reminder * 10) + currentDigit(dividend, digitsChecked);
            int changingDivisor = (changingDividend / divisor) * divisor;
            reminder = changingDividend % divisor;

            if (changingDividend < divisor) {
                digitsChecked++;
                continue;
            } else if (visualResult.equals("")) {
                visualResult = visualResult.concat(StringConstuctor.firstWriteString(dividend,
                        divisor, changingDividend, changingDivisor));
                digitsChecked++;
                continue;
            }

            visualResult = visualResult.concat(StringConstuctor.writingString(changingDividend,
                    changingDivisor, digitsChecked));
            digitsChecked++;
        }
        visualResult = visualResult.concat(" ".repeat(numberLength(dividend)
                - numberLength(reminder) + 1) + reminder);

        return visualResult;
    }

    private static void inputCheck(int dividend, int divisor) {
        if (dividend < 0 || divisor < 0) {
            throw new IllegalArgumentException("Calculation with negative numbers is still developing... " +
                    "Sorry for the inconveniences");
        } else if (divisor == 0) {
            throw new IllegalArgumentException("Dividing by zero isn't allowed");
        } else if (dividend < divisor) {
            throw new IllegalArgumentException("Dividend is less than divisor...");
        }
    }

    private static int currentDigit(int dividend, int i) {
        return CalculationMethodsHelper.takeDigitFromNumber(dividend, i);
    }

    private static int numberLength(int dividend) {
        return CalculationMethodsHelper.numberLength(dividend);
    }
}
