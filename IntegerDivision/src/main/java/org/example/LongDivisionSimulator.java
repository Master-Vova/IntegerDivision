package org.example;

import java.util.Scanner;

public class LongDivisionSimulator {
    public static void main(String[] args) {

        Scanner write = new Scanner(System.in);

        System.out.println("Type a dividend:");
        int dividend = write.nextInt();
        System.out.println("Type a divisor:");
        int divisor = write.nextInt();

        System.out.println(DivisionProcessUtil.process(dividend, divisor));

    }
}