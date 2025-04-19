package com.karn.tleeliminator.week1;

import java.util.Scanner;

//https://codeforces.com/edu/course/2/lesson/6/3/practice/contest/285083/problem/A
public class GetTogether {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[][] posSpeed = new int[n][2];
            for (int i = 0; i < n; i++) {
                posSpeed[i][0] = sc.nextInt();
                posSpeed[i][1] = sc.nextInt();
            }
            double solution = findMinTime(posSpeed);
            System.out.println(solution);
        }
    }

    private static double findMinTime(int[][] posSpeed) {
        double left = 0;
        double right = (int) (1e10);
        double precision = 1e-7;
        double result = right;
        for (int i = 0; i < 100; i++) {
            double mid = left + (right - left) / 2;
            if (isPossibleToMeet(mid, posSpeed)) {
                result = Math.min(result, mid);
                right = mid - precision;
            } else {
                left = mid + precision;
            }

        }
        return result;
    }

    private static boolean isPossibleToMeet(double time, int[][] posSpeed) {
        double dist = posSpeed[0][1] * time;
        double leftMin = posSpeed[0][0] - dist;
        double rightMax = posSpeed[0][0] + dist;
        for (int i = 1; i < posSpeed.length; i++) {
            int pos = posSpeed[i][0];
            int speed = posSpeed[i][1];
            dist = speed * time;
            leftMin = Math.max(pos - dist, leftMin);
            rightMax = Math.min(pos + dist, rightMax);
            if (leftMin > rightMax) {
                return false;
            }
        }
        return true;
    }

}
