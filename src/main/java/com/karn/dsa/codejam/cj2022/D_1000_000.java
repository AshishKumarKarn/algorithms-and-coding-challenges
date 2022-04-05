package com.karn.dsa.codejam.cj2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

//D_1000_000
public class D_1000_000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {

            int n = sc.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = sc.nextInt();
            }
            Arrays.sort(array);
            int solution = solveDice(array);
            System.out.println("Case #" + i + ": "+solution);
        }
    }

    private static int solveDice(int[] array) {
        int count=1;
        for (int j : array) {
            if (count <= j) {
                count++;
            }
        }
        return count-1;
    }
}
