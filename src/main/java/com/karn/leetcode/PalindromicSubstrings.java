package com.karn.leetcode;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += calculatePalindromicSubstrings(s, i, i);
            result += calculatePalindromicSubstrings(s, i, i + 1);
        }
        return result;
    }

    private int calculatePalindromicSubstrings(String characters, int i, int j) {
        int result = 0;
        while (i >= 0 && j < characters.length()) {
            if (characters.charAt(i) != characters.charAt(j)) {
                break;
            }
            ++result;
            --i;
            ++j;
        }
        return result;
    }
}
