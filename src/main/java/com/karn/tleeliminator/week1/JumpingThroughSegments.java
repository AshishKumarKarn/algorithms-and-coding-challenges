package com.karn.tleeliminator.week1;
//https://codeforces.com/problemset/problem/1907/D

import java.util.Scanner;

/**
 * you can check if it is possible to make the all jumps with the value (mid of Binary search)
 */
public class JumpingThroughSegments {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int testCases = sc.nextInt();
            while (testCases > 0) {
                int n = sc.nextInt();
                int[][] ranges = new int[n][2];
                for (int i = 0; i < n; i++) {
                    ranges[i][0] = sc.nextInt();
                    ranges[i][1] = sc.nextInt();
                }
                int answer = findMinimumJump(ranges);
                System.out.println(answer);
                testCases--;
            }
        }
    }

    private static int findMinimumJump(int[][] ranges) {
        int left = 0;
        int right = (int) 1e9;
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(mid, ranges)) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static boolean isPossible(int k, int[][] ranges) {
        int minPos = 0;
        int maxPos = 0;
        for (int[] range : ranges) {
            minPos = Math.max(minPos - k, range[0]);
            maxPos = Math.min(maxPos + k, range[1]);
            if ((minPos > maxPos)) {
                return false;
            }
        }
        return true;
    }


}
