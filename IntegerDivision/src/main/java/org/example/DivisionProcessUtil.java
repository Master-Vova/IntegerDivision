package org.example;

public class DivisionProcessUtil {

    public static String process(int dividend, int divisor) {

        int digitsChecked = 0;
        int reminder = 0;
        String visualResult = "";

        while (digitsChecked < numberLength(dividend)) {

            int changingDividend = (reminder * 10) + stepNumber(dividend, digitsChecked);
            int changingDivisor = (changingDividend / divisor) * divisor;
            reminder = changingDividend % divisor;

            if (changingDividend < divisor) {
                digitsChecked++;
                continue;
            } else if (visualResult == "") {
                visualResult = visualResult.concat(firstWriteString(dividend,
                        divisor, changingDividend, changingDivisor));
                digitsChecked++;
                continue;
            }

            visualResult = visualResult.concat(writingString(changingDividend, changingDivisor, digitsChecked));
            digitsChecked++;
        }
        visualResult = visualResult.concat(" ".repeat(numberLength(dividend)
                - numberLength(reminder) + 1) + reminder);

        return visualResult;
    }

    protected static String firstWriteString(int initialDividend, int initialDivisor,
                                             int changingDividend, int changingDivisor) {

        int dif = checkIfNumberLengthHasDifference(changingDividend, changingDivisor);

        String result = "_" + initialDividend + "│" + initialDivisor + "\n" +
                " ".repeat(dif + 1) + changingDivisor +
                " ".repeat(numberLength(initialDividend) - dif - numberLength(changingDivisor)) +
                "│" + "-".repeat(numberLength((initialDividend / initialDivisor))) + "\n" +
                " --" + " ".repeat(numberLength(initialDividend) - dif - numberLength(changingDivisor)) +
                "│" + (initialDividend / initialDivisor) + "\n";

        return result;
    }

    protected static String writingString(int dividend, int divisor, int i) {

        int x = i - numberLength(dividend) + 2;
        int dif = checkIfNumberLengthHasDifference(dividend, divisor);

        String result = " ".repeat(x - 1) + "_" + dividend + "\n" +
                " ".repeat(x + dif) + divisor + "\n" +
                " ".repeat(x + dif) +
                "-".repeat(numberLength(divisor)) + "\n";
        return result;
    }

    protected static int stepNumber(int dividend, int i) {
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
