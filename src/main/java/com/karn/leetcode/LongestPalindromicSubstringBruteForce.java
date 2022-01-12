package com.karn.leetcode;

import java.io.FileInputStream;
import java.util.Scanner;

public class LongestPalindromicSubstringBruteForce {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new FileInputStream("LongestPalindromic.txt"));
        String input = sc.next();
        System.out.println(new LongestPalindromicSubstringBruteForce()
                .longestPalindrome(input));
    }

    public String longestPalindrome(String string) {
        if (string.length() == 1) {
            return string;
        }
        int max = 0;
        String lps = null;
        for (int cursor = 0; cursor < string.length(); cursor++) {
            Result result1 = longestPalindromicEven(cursor, string);
            Result result2 = longestPalindromicOdd(cursor, string);
            Result result = result1.length > result2.length ? result1 : result2;
            if (max < result.length) {
                max = result.length;
                lps = result.string;
            }
        }
        return lps;
    }

    private class Result {
        Result() {
        }

        Result(int length, String string) {
            this.length = length;
            this.string = string;
        }

        public int length;
        public String string;
    }

    private Result longestPalindromicOdd(int cursor, String string) {
        Result result = new Result();
        for (int i = cursor, radius = 0; (i - radius) >= 0 && (i + radius + 1) <= string.length(); radius++) {
            String substring = string.substring(i - radius, i + radius + 1);
            if (isPalindrome(substring)) {
                result.length = 2 * radius + 1;
                result.string = substring;
            }else {
                break;
            }
        }
        return result;
    }

    private Result longestPalindromicEven(int cursor, String string) {
        if (cursor >= string.length() - 1 ||
                string.charAt(cursor) != string.charAt(cursor + 1)) {
            return new Result(0, "");
        }
        Result result = new Result();
        for (int i = cursor, radius = 0; (i - radius) >= 0 && (i + radius + 2) < string.length() + 1; radius++) {
            String substring = string.substring(i - radius, i + radius + 2);
            if (isPalindrome(substring)) {
                result.length = 2 * radius + 2;
                result.string = substring;
            } else {
                break;
            }
        }
        return result;
    }


    private boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
