package org.example;

public class Calculation {
    int reminder = 0;
    int changingDividend = 0;
    int changingDivisor = 0;

    public void performDivision(int divisor, int digit){

            changingDividend = (reminder * 10) + digit;
            changingDivisor = (changingDividend / divisor) * divisor;
            reminder = changingDividend % divisor;
    }

}
