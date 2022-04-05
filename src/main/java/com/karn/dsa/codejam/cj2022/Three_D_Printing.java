package com.karn.dsa.codejam.cj2022;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

//3D_Printing
public class Three_D_Printing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            //3 rows for three D's and 4 columns for 4 colors
            int[][] colors = new int[3][4];
            for (int j = 0; j < colors.length; j++) {
                for (int k = 0; k < colors[j].length; k++) {
                    colors[j][k] = sc.nextInt();
                }
            }
            String sol = solve(colors);
            System.out.print("Case #" + i + ": ");
            System.out.println(sol);
        }
    }

    private static String solve(int[][] colors) {
        int[] cartridges = new int[4];
        // Arrays.fill(cartridges, Integer.MAX_VALUE);
        for (int j = 0; j < 4; j++) {
            int val = colors[0][j];
            for (int i = 1; i < 3; i++) {
                val = Math.min(val, colors[i][j]);
                if (i == 2) {
                    cartridges[j] = val;
                }
            }
        }
        int sum = Arrays.stream(cartridges).reduce(Integer::sum).getAsInt();
        if (sum < 1000_000) {
            return "IMPOSSIBLE";
        }
        StringBuilder sb = new StringBuilder();
        sum = 0;
        boolean firstTime = true;
        for (int cartridge : cartridges) {
            sum += cartridge;
            if (sum > 1000_000) {
                sum -= cartridge;
                if (firstTime) {
                    sb.append(1000_000 - sum);
                } else {
                    sb.append(0);
                }
                firstTime = false;
                sum = 1000_000;
            } else {
                sb.append(cartridge);
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
