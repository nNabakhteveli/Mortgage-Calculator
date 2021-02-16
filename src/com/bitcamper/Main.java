package com.bitcamper;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        int principal;
        while(true){
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if(principal >= 1_000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000.");
        }

        float annualInterest;
        while(true){
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if(annualInterest > 0 && annualInterest <= 30)
                break;
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();

        int numberOfPayments = years * MONTHS_IN_YEAR;
        double mortgage = principal
                *(monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
