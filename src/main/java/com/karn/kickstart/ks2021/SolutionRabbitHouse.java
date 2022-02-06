package com.karn.kickstart.ks2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class SolutionRabbitHouse {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {

            int r = in.nextInt();
            int c = in.nextInt();
            long[][] grid = new long[r][c];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    grid[j][k] = in.nextLong();
                }
            }


            System.out.println(Arrays.deepToString(grid));
            System.out.println(r + " " + c);
            long result = solve(grid);
            System.out.println(Arrays.deepToString(grid));
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static class MaxLoc {
        int i;
        int j;
        long val;

        MaxLoc(int i, int j, long val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    private static long solve(long[][] grid) {
        long val = Long.MIN_VALUE;
        MaxLoc maxLoc = null;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > val) {
                    val = grid[i][j];
                    maxLoc = new MaxLoc(i, j, val);
                }
            }
        }
        boolean[][] arr = new boolean[grid.length][grid[0].length];
        arr[maxLoc.i][maxLoc.j] = true;
        Queue<MaxLoc> maxLocs = new ArrayDeque<>();
        maxLocs.add(maxLoc);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == val && !arr[i][j]) {

                    maxLocs.add(new MaxLoc(i, j, val));
                }
            }
        }
        long result = 0;
        while (!maxLocs.isEmpty()) {
            MaxLoc poll = maxLocs.poll();
            result = result + addAndIncrementNeighbour(arr, maxLocs, poll.val, poll.i + 1, poll.j, grid);
            result = result + addAndIncrementNeighbour(arr, maxLocs, poll.val, poll.i - 1, poll.j, grid);
            result = result + addAndIncrementNeighbour(arr, maxLocs, poll.val, poll.i, poll.j + 1, grid);
            result = result + addAndIncrementNeighbour(arr, maxLocs, poll.val, poll.i, poll.j - 1, grid);
        }
        return result;
    }

    private static long addAndIncrementNeighbour(boolean[][] arr, Queue<MaxLoc> queue, long val, int i, int j, long[][] grid) {
        if (i < grid.length && i >= 0 && j < grid[i].length && j >= 0) {
            if (!arr[i][j]) {
                arr[i][j] = true;
                if ((val - grid[i][j] > 1)) {
                    queue.add(new MaxLoc(i, j, (val - 1)));
                    long gridIJ = grid[i][j];
                    grid[i][j] = val - 1;
                    return val - gridIJ - 1;
                } else if ((val - grid[i][j] == 1 || val - grid[i][j] == 0)) {
                    queue.add(new MaxLoc(i, j, grid[i][j]));
                }
            }
        }
        return 0;
    }
}
