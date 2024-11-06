package com.karn.facebook.hackercup;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            double testCases = sc.nextDouble();
            int t = 1;
            while (testCases > 0) {
                double N = sc.nextDouble();
                double P = sc.nextDouble();

                System.out.println("Case #" + (t++) + ": " + solve(N, P));

                testCases--;
            }
        }
    }
    private static double solve(double N, double P){
        double p = P/100;
        double q = Math.pow(p, (N-1)/N);
        return (q-p)*100;
    }
}
