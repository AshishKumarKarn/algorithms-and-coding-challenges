package com.karn.leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int number = i;
            System.out.printf("Number %s is %s %n", number, new PalindromeNumber().isPalindrome(number));

        }
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String x_string = String.valueOf(x);
        int length = x_string.length();
        int half = length / 2;
        for (int i = 0; i < half; i++) {
            if (x_string.charAt(i) != x_string.charAt(length -1 - i)) {
                return false;
            }
        }
        return true;
    }
}
