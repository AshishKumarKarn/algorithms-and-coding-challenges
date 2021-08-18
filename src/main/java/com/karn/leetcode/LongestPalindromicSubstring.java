package com.karn.leetcode;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestPalindromicSubstring {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(new FileInputStream("LongestPalindromic.txt"));
        String input=sc.next();
        System.out.println(new LongestPalindromicSubstring()
                .longestPalindrome(input));
    }

    public String longestPalindrome(String string) {
        if (string.length() == 1) {
            return string;
        }
        int max = 0;


        return null;
    }

    private List<String> allSubStrings(String string) {
        List<String> allSubStrings = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            for (int j = i ; j < string.length(); j++) {
                allSubStrings.add(string.substring(i, j+1));
            }
        }
        return allSubStrings;
    }

    private boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
