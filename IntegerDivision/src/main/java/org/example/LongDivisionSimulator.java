package org.example;

import java.util.Scanner;

public class LongDivisionSimulator {
    public static void main(String[] args) {

        Scanner write = new Scanner(System.in);

        System.out.println("Type a dividend:");
        int dividend = write.nextInt();
        System.out.println("Type a divisor:");
        int divisor = write.nextInt();


        IntegerDivision integerDivision = new IntegerDivision();
        DivisionResult result = integerDivision.calculate(dividend, divisor);

        DivisionFormatter formatter = new DivisionFormatter();
        String resultString = formatter.formatResult(result);

        System.out.println(resultString);
    }
}