package com.karn.leetcode;

import java.io.FileInputStream;
import java.util.Scanner;

public class LongestPalindromicSubstringDynamicProgramming {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new FileInputStream("LongestPalindromic.txt"));
        String input = sc.next();
        System.out.println(new LongestPalindromicSubstringDynamicProgramming()
                .longestPalindrome(input));
    }

    public String longestPalindrome(String string) {
        int length = string.length();
        int[][] dp = new int[length][length];
        String max = "";

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        int k = 0;
        for (int i = k; k < length - 1 && i < length - 1; ) {
            for (int j = i + 1; j < length; i++, j++) {
                if (string.charAt(i) == string.charAt(j)
                        && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    int len = j + 1 - i;
                    if (len > max.length()) {
                        max = string.substring(i, j + 1);
                    }
                }
            }
            ++k;
            i = k;
        }
        return max;
    }
}
