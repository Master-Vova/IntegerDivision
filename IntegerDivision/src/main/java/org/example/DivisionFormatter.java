package org.example;

class DivisionFormatter{
    int initialDividend;
    int initialDivisor;
    StringBuilder result = new StringBuilder();

    DivisionFormatter(int dividend, int divisor) {
        this.initialDividend = dividend;
        this.initialDivisor = divisor;
    }

    public void writeString(int changingDividend, int changingDivisor, int i) {

        if (result.isEmpty()) {
            writeStringForFirstTime(changingDividend, changingDivisor);
            return;
        }

        int x = i - DigitsUtil.getNumberLength(changingDividend) + 2;
        int dif = DigitsUtil.lengthItDifferent(changingDividend, changingDivisor) ? 1 : 0;

        result
                .append(" ".repeat(x - 1) + "_" + changingDividend + "\n")
                .append(" ".repeat(x + dif) + changingDivisor + "\n")
                .append(" ".repeat(x + dif) + "-".repeat(
                        DigitsUtil.getNumberLength(changingDivisor)) + "\n");
    }

    public void writeLastLine(int reminder) {
        result.append(" ".repeat(DigitsUtil.getNumberLength(initialDividend)
                - DigitsUtil.getNumberLength(reminder) + 1) + reminder);
    }

    private void writeStringForFirstTime(int changingDividend, int changingDivisor) {

        int quotient = initialDividend / initialDivisor;
        int dif = DigitsUtil.lengthItDifferent(changingDividend, changingDivisor) ? 1 : 0;
        String spaceAfter = " ".repeat(DigitsUtil.getNumberLength(initialDividend) -
                dif - DigitsUtil.getNumberLength(changingDivisor));
        String spaceBefore = " ".repeat(dif + 1);

        result
                .append("_" + initialDividend + "│" + initialDivisor + "\n")
                .append(spaceBefore + changingDivisor + spaceAfter + "│" +
                        "-".repeat(DigitsUtil.getNumberLength(quotient)) + "\n")
                .append(spaceBefore + "-".repeat(DigitsUtil.getNumberLength(changingDivisor)) + spaceAfter +
                        "│" + quotient + "\n");
    }
}
