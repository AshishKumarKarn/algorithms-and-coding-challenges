package com.karn.leetcode;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(new SumOfTwoIntegers().getSum(30, -20));
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }
}
