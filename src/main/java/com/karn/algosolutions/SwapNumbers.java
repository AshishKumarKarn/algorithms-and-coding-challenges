package com.karn.algosolutions;

public class SwapNumbers {
    public static void main(String[] args) {
        int x = 15, y = 24;
        //swap method 1;
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.printf("x is %s and y is %s %n", x, y);

        //reset
        x = 15;
        y = 24;
        //swap method 2;
        System.out.println("x >"+0+Integer.toBinaryString(x));
        System.out.println("y >"+Integer.toBinaryString(y));

        x = x ^ y;//different bits
        System.out.println("x >"+Integer.toBinaryString(x));
        y = x ^ y;
        System.out.println("y >"+0+Integer.toBinaryString(y));
        x = x ^ y;
        System.out.println("x >"+Integer.toBinaryString(x));
        System.out.printf("x is %s and y is %s %n", x, y);
    }
}
