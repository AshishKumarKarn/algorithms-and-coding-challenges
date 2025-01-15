package com.karn.codeforces.edu;

import java.util.Scanner;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextDouble();
            }
            System.out.println(solve(n, k, arr));
        }
    }

    private static double solve(int n, int k, double[] arr) {

        double precision = 1e-8;
        double left = precision;
        double right = 1e8;
        double result = 0;
        for (int it = 0; it < 100; it++) {
            double mid = left + (right - left) / 2;
            if (possible(mid, n, k, arr)) {
                result = Math.max(mid, result);
                left = mid + precision;
            } else {
                right = mid - precision;
            }
        }
        return result;
    }

    private static boolean possible(double mid, int n, int k, double[] arr) {
        for (int i = 0; i < n; i++) {
            int part = (int) (arr[i] / mid);
            k = k - part;
            if (k <= 0) {
                return true;
            }
        }
        return false;
    }

}