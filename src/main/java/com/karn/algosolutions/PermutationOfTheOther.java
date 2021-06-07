package com.karn.algosolutions;

import java.util.Arrays;

public class PermutationOfTheOther {
    public static void main(String[] args) {
        System.out.println(isPermutation("abc", "bca"));
        System.out.println(isPermutation("abcd", "bxya"));
    }

    private static boolean isPermutation(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        if (char1.length != char2.length) return false;
        Arrays.sort(char1);
        Arrays.sort(char2);
        for (int i = 0; i < char1.length; i++) {
            if (char1[i] != char2[i]) {
                return false;
            }
        }
        return true;
    }
}
