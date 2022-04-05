package com.karn.dsa.codejam.cj2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//PunchedCard
public class PunchedCard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            String sol = getSolution(R, C);
            System.out.println("Case #" + i + ":");
            System.out.println(sol);
        }
    }

    private static String getSolution(int r, int c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 2 * r; i++) {
            for (int j = 0; j < c; j++) {
                if (i % 2 == 0) {
                    if (i == 0 && j == 0) {
                        sb.append("..+");
                    } else if (j == 0) {
                        sb.append("+-+");
                    } else {
                        sb.append("-+");
                    }
                } else {
                    if (i == 1 && j == 0) {
                        sb.append("..|");
                    } else if (j == 0) {
                        sb.append("|.|");
                    } else {
                        sb.append(".|");
                    }
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
