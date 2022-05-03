package com.karn.kickstart.ks2021.roundA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PalindromeFreeStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = sc.nextInt();
            String number = sc.next();
            String result;
            if (alreadyHasPalindromeOf5_or6Length(number)) {
                result = "IMPOSSIBLE";
            } else {
                result = solveString(number);
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solveString(String number) {
        int countPlaceholder = countPlaceHolder(number);
        if(countPlaceholder>4){
            return "IMPOSSIBLE";
        }
        return solve(number);
    }

    private static String solve(String number) {
        return null;
    }

    private static int countPlaceHolder(String number) {
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '?') {
                count++;
            }
        }
        return count;
    }

    private static boolean alreadyHasPalindromeOf5_or6Length(String number) {
        if (number.length() < 5) {
            return false;
        }
        for (int i = 4; i < number.length() - 4; i++) {
            checkPalindrom(i, i, number);
            checkPalindrom(i, i + 1, number);
        }
        if (palindromicCount >= 5) {
            //reset value for other test case
            palindromicCount = 0;
            return true;
        }
        return false;
    }

    static int palindromicCount = 0;

    private static void checkPalindrom(int i, int j, String number) {
        int count = 0;
        while (i >= 0 && j < number.length()) {
            if (number.charAt(i) == number.charAt(j)) {
                count++;
                i--;
                j++;
                if (count == 5) {
                    break;
                }
            }
        }
        if (count > palindromicCount) {
            palindromicCount = count;
        }
    }
}
