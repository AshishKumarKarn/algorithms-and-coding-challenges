package com.karn.leetcode;

import java.io.FileInputStream;
import java.util.Scanner;

public class LongestPalindromicSubstring {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new FileInputStream("LongestPalindromic.txt"));
        String input = sc.next();
        System.out.println(new LongestPalindromicSubstring()
                .longestPalindrome(input));
    }

    private int startIndex;
    private int length;

    public String longestPalindrome(String string) {
        if (string == null || string.length() < 2) {
            return string;
        }
        int strLength = string.length();
        for (int start = 0; start < strLength - 1; start++) {
            expandRange(string, start, start);
            expandRange(string, start, start + 1);
        }

        return string.substring(startIndex, startIndex + length);
    }

    private void expandRange(String string, int begin, int end) {
        while (begin >= 0 && end < string.length()
                && string.charAt(begin) == string.charAt(end)) {
            begin--;
            end++;
        }
        int length = end - begin - 1;
        if (this.length < length) {
            this.startIndex = begin+1;
            this.length = length;
        }
    }
}
