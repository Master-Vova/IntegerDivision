package org.example;

class DivisionFormatter{
    private int initialDividend;
    private int initialDivisor;
    private StringBuilder resultString = new StringBuilder();

    public String formatResult(DivisionResult result){

        this.initialDividend = result.initialDividend();
        this.initialDivisor = result.initialDivisor();

        int step = 0;

        while (step < DigitsUtil.getNumberLength(result.initialDividend())) {
            if (result.arr()[0][step] == 1) {
                step++;
                continue;
            }
            writeString(result.arr()[1][step], result.arr()[2][step], step);
            step++;
        }
        writeLastLine(result.reminder());

        return this.resultString.toString();
    }

    private void writeString(int changingDividend, int changingDivisor, int i) {

        if (resultString.isEmpty()) {
            writeStringForFirstTime(changingDividend, changingDivisor);
            return;
        }

        int x = i - DigitsUtil.getNumberLength(changingDividend) + 2;
        int dif = DigitsUtil.lengthItDifferent(changingDividend, changingDivisor) ? 1 : 0;

        resultString
                .append(" ".repeat(x - 1) + "_" + changingDividend + "\n")
                .append(" ".repeat(x + dif) + changingDivisor + "\n")
                .append(" ".repeat(x + dif) + "-".repeat(
                        DigitsUtil.getNumberLength(changingDivisor)) + "\n");
    }

    private void writeLastLine(int reminder) {
        resultString.append(" ".repeat(DigitsUtil.getNumberLength(initialDividend)
                - DigitsUtil.getNumberLength(reminder) + 1) + reminder);
    }

    private void writeStringForFirstTime(int changingDividend, int changingDivisor) {

        int quotient = initialDividend / initialDivisor;
        int dif = DigitsUtil.lengthItDifferent(changingDividend, changingDivisor) ? 1 : 0;
        String spaceAfter = " ".repeat(DigitsUtil.getNumberLength(initialDividend) -
                dif - DigitsUtil.getNumberLength(changingDivisor));
        String spaceBefore = " ".repeat(dif + 1);

        resultString
                .append("_" + initialDividend + "│" + initialDivisor + "\n")
                .append(spaceBefore + changingDivisor + spaceAfter + "│" +
                        "-".repeat(DigitsUtil.getNumberLength(quotient)) + "\n")
                .append(spaceBefore + "-".repeat(DigitsUtil.getNumberLength(changingDivisor)) + spaceAfter +
                        "│" + quotient + "\n");
    }
}
