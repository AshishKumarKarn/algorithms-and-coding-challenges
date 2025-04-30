package com.karn.tleeliminator.week2;

import java.util.Arrays;
import java.util.Scanner;

public class PairSelection {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] pairs = new int[n][2];
            for (int i = 0; i < n; i++) {
                pairs[i][0] = sc.nextInt();
                pairs[i][1] = sc.nextInt();
            }
            double solution = getMaxRation(pairs, k);
            System.out.println(solution);
        }
    }

    private static double getMaxRation(int[][] pairs, int k) {

        double left = 0;
        double right = 1e7;
        double result = 0;
        double precision = 1e-7;
        for (int i = 0; i < 60; i++) {
            double mid = left + (right - left) / 2;
            double[] c = getRatioWithMids(pairs, i, mid);
            if (isRatioPossible(k, c)) {
                left = mid + precision;
                result = mid;
            } else {
                right = mid - precision;
            }

        }
        return result;
    }

    private static double[] getRatioWithMids(int[][] pairs, int i, double mid) {
        double[] c = new double[pairs.length]; //c = a- xb;
        for (int[] pair : pairs) {
            c[i] = pair[0] - mid * pair[1];
        }
        Arrays.sort(c);
        return c;
    }

    private static boolean isRatioPossible(int k, double[] c) {

        double ratio = 0;
        for (int i = c.length - 1; i >= c.length - k; i--) {
            ratio += c[i];
        }
        return ratio >= 0;

    }
}
