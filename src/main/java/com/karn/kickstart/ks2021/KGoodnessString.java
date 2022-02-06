package com.karn.kickstart.ks2021;

import java.util.*;
import java.io.*;
//public class Solution {
public class KGoodnessString {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            String str = in.next();
            int goodNess = 0;
            for (int j = 0; j < n / 2; j++) {
                if (str.charAt(j) != str.charAt(n - j - 1)) {
                    goodNess++;
                }
            }
            goodNess = Math.abs(m-goodNess);
            System.out.println("Case #" + i + ": " + goodNess);
        }
    }
}
