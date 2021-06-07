package com.karn.algosolutions;

import java.math.BigInteger;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println(fib(1000000));
    }

    private static BigInteger fib(int n) {
        if (n == 0) return new BigInteger("0");
        if (n == 1) return new BigInteger("1");

        BigInteger num1 = new BigInteger("0");
        BigInteger num2 = new BigInteger("1");
        BigInteger num = num1;
        //calculate till last number
        for (int i = 1; i < n; i++) {
            num = num2.add(num1);
            num1 = num2;
            num2 = num;
        }
        return num;
    }
}
