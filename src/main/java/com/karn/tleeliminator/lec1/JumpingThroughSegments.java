package com.karn.tleeliminator.lec1;
//https://codeforces.com/problemset/problem/1907/D

import java.util.ArrayList;
import java.util.List;
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
                int maxRange = 0;
                for (int i = 0; i < n; i++) {
                    ranges[i][0] = sc.nextInt();
                    ranges[i][1] = sc.nextInt();
                    maxRange = Math.max(maxRange, ranges[i][1]);
                    maxRange = Math.max(maxRange, ranges[i][0]);
                }
                int answer = findMinimumJump(ranges, maxRange);
                System.out.println(answer);
                testCases--;
            }
        }
    }

    private static int findMinimumJump(int[][] ranges, int maxRange) {
        int left = 0;
        int right = maxRange;
        for (int i = 0; i < 50; i++) {
            int mid = left + (right - left) / 2;
            if (isPossibleToMakeJump(mid, ranges)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private static boolean isPossibleToMakeJump(int mid, int[][] ranges) {
        int currentPosition = 0;
        int maxDistance = 0;
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            if (range[0] <= currentPosition && range[1] >= currentPosition) {
                continue;
            }
            if (range[1] < currentPosition) {
                maxDistance = Math.max(maxDistance, currentPosition - range[1]);
                currentPosition = Math.min(currentPosition-mid,range[0]+(range[1]-range[0])/2);
            } else {
                maxDistance = Math.max(maxDistance, range[0] - currentPosition);
                currentPosition = Math.min(currentPosition+mid,range[0]+(range[1]-range[0])/2);
            }
        }
        return maxDistance <= mid;
    }

}
