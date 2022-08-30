package com.karn.kickstart.ks2022.practice.season3;


import java.util.Scanner;

/**
 * Starter Code for Sherlock and Watson Gym Secrets.*
 */
public class SherlockAndWatson {

    /**
     * Complete the countPairs function
     */
    static int countPairs(int a, int b, long n, int k) {
        int pairs = 0;
        // TODO: Add logic to count the number of pairs modulo 10^9+7 (1000000007)
        for (long i = 1; i <= n; i++) {
            for (long j = 1; j <= n;j++ ) {
                if (isAnswer(i, j, a, b, k)) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    private static boolean isAnswer(long i, long j, int a, int b, int k) {
        return i != j && (((int)Math.pow(i, a) +(int) Math.pow(j, b))) % k == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the number of test cases.
        int testCaseCount = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= testCaseCount; caseIndex++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            long n = scanner.nextLong();
            int k = scanner.nextInt();

            int pairs = countPairs(a, b, n, k);
            System.out.println("Case #" + caseIndex + ": " + pairs);
        }
    }
}
