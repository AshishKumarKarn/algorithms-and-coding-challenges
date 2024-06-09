package com.karn.javatricks.core;

public class DecimalToBinaryRepresentation {
    public static void main(String[] args) {
        int number = 20;
        int ones_comp = number ^ ((1 << 31) - 1);//flip all digits
        System.out.println(Integer.toBinaryString(ones_comp));
        int twos_comp = ones_comp + 1; // add one to ones compliment will give 2's complement
        System.out.println(Integer.toBinaryString(twos_comp));
        int signedBit = 1 << 31; //although it fits in int as signed bit
        int negative = signedBit + twos_comp;
        System.out.println(negative);
        System.out.println(Integer.toBinaryString(negative));
        System.out.println(Integer.toBinaryString(-20));
    }
}
