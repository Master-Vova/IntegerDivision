package org.example;

public class DivisionFormatter {

    public String formatResult(DivisionResult result) {
        validate(result);

        StringBuilder resultString = new StringBuilder();
        int step = 0;

        while (step < DigitsUtil.getNumberLength(result.initialDividend())) {
            if (result.arr()[0][step] == 1) {
                step++;
                continue;
            } else if (resultString.isEmpty()) {
                resultString.append(writeStringForFirstTime(result.initialDividend(), result.initialDivisor(),
                        result.arr()[1][step], result.arr()[2][step]));
                step++;
                continue;
            }
            resultString.append(writeString(result.arr()[1][step], result.arr()[2][step], step));
            step++;
        }
        resultString.append(writeLastLine(result.initialDividend(), result.reminder()));
        return resultString.toString();
    }

    private StringBuilder writeString(int changingDividend, int changingDivisor, int i) {

        int x = i - DigitsUtil.getNumberLength(changingDividend) + 2;
        int dif = DigitsUtil.lengthItDifferent(changingDividend, changingDivisor) ? 1 : 0;

        return new StringBuilder()
                .append(" ".repeat(x - 1))
                .append("_")
                .append(changingDividend)
                .append("\n")
                .append(" ".repeat(x + dif))
                .append(changingDivisor)
                .append("\n")
                .append(" ".repeat(x + dif))
                .append("-".repeat(DigitsUtil.getNumberLength(changingDivisor)))
                .append("\n");
    }

    private StringBuilder writeStringForFirstTime(int initialDividend, int initialDivisor,
                                                  int changingDividend, int changingDivisor) {

        int quotient = initialDividend / initialDivisor;
        int dif = DigitsUtil.lengthItDifferent(changingDividend, changingDivisor) ? 1 : 0;
        String spaceAfter = " ".repeat(DigitsUtil.getNumberLength(initialDividend) -
                dif - DigitsUtil.getNumberLength(changingDivisor));
        String spaceBefore = " ".repeat(dif + 1);

        return new StringBuilder()
                .append("_")
                .append(initialDividend)
                .append("│")
                .append(initialDivisor)
                .append("\n")
                .append(spaceBefore)
                .append(changingDivisor)
                .append(spaceAfter)
                .append("│")
                .append("-".repeat(DigitsUtil.getNumberLength(quotient)))
                .append("\n")
                .append(spaceBefore)
                .append("-".repeat(DigitsUtil.getNumberLength(changingDivisor)))
                .append(spaceAfter)
                .append("│")
                .append(quotient)
                .append("\n");
    }

    private StringBuilder writeLastLine(int initialDividend, int reminder) {
        return new StringBuilder()
                .append(" ".repeat(DigitsUtil.getNumberLength(initialDividend)
                        - DigitsUtil.getNumberLength(reminder) + 1))
                .append(reminder);
    }


    private void validate(DivisionResult recordData) {

        if (recordData.initialDividend() < 0 || recordData.initialDivisor() < 0 ||
                recordData.reminder() < 0) {
            int argument = 0;
            argument = (recordData.initialDividend() < 0) ? 1 :
                    (recordData.initialDivisor() < 0) ? 2 : argument;

            switch (argument) {
                case 1 -> throw new IllegalArgumentException(recordData.initialDividend() +
                        " value of dividend is less than zero isn't allowed...");
                case 2 -> throw new IllegalArgumentException(recordData.initialDivisor() +
                        " value of divisor is less than zero" + " isn't allowed...");
                case 0 -> throw new IllegalArgumentException("Remainder is negative, its shouldn't be possible");
            }
        } else if (recordData.initialDivisor() == 0) {
            throw new IllegalArgumentException("Dividing by zero isn't allowed");
        } else if (recordData.initialDividend() < recordData.initialDivisor()) {
            throw new IllegalArgumentException("Dividend is less than divisor...");
        } else if (recordData.arr() == null) {
            throw new IllegalArgumentException("Formatter got empty array");
        } else if (!(recordData.arr()[0].length == recordData.arr()[1].length
                && recordData.arr()[1].length == recordData.arr()[2].length
                && recordData.arr()[2].length == DigitsUtil.getNumberLength(recordData.initialDividend()))) {
            throw new IllegalArgumentException("Something wrong with array length");
        }

        for (int[] rows : recordData.arr()) {
            for (int num : rows) {
                if (num < 0)
                    throw new IllegalArgumentException("Array has negative value");
            }
        }
    }
}
