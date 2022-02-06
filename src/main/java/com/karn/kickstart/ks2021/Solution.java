package com.karn.kickstart.ks2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt();
            int c = in.nextInt();
            int count = 0;
            int[][] grid = new int[r][c];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    grid[j][k] = in.nextInt();
                }
            }
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if (grid[j][k] == 1) {
                        count += checkLs(grid, j, k);
                    }
                }
            }

            System.out.println("Case #" + i + ": " + count);
        }
    }

    private static int checkLs(int[][] grid, int j, int k) {
        int result = 0;
        //up
        result += isCenterOfL(grid, j, k, true, true);
        //left
        result += isCenterOfL(grid, j, k, true, false);
        //down
        result += isCenterOfL(grid, j, k, false, false);
        //right
        result += isCenterOfL(grid, j, k, false, true);
        return result;
    }

    private static int isCenterOfL(int[][] grid, int i, int j, boolean o, boolean p) {
        int result = 0;
        if (o && p) {
            ArrayList<Integer> segmentVertical = new ArrayList<>();
            for (int k = i; k >= 0; k--) {
                if (grid[k][j] == 0) {
                    break;
                }
                segmentVertical.add(grid[k][j]);
                ArrayList<Integer> segmentHorizontal = new ArrayList<>();
                for (int l = j; l < grid[i].length; l++) {
                    if (grid[i][l] == 0) {
                        break;
                    }
                    segmentHorizontal.add(grid[i][l]);
                    if (areMakingL(segmentHorizontal, segmentVertical)) {
                        result++;
                    }
                }
            }
        } else if (o) {
            ArrayList<Integer> segmentVertical = new ArrayList<>();
            for (int k = i; k >= 0; k--) {
                if (grid[k][j] == 0) {
                    break;
                }
                segmentVertical.add(grid[k][j]);
                ArrayList<Integer> segmentHorizontal = new ArrayList<>();
                for (int l = j; l >= 0; l--) {
                    if (grid[i][l] == 0) {
                        break;
                    }
                    segmentHorizontal.add(grid[i][l]);
                    if (areMakingL(segmentHorizontal, segmentVertical)) {
                        result++;
                    }
                }
            }

        } else if (p) {
            ArrayList<Integer> segmentVertical = new ArrayList<>();
            for (int k = i; k < grid.length; k++) {
                if (grid[k][j] == 0) {
                    break;
                }
                segmentVertical.add(grid[k][j]);
                ArrayList<Integer> segmentHorizontal = new ArrayList<>();
                for (int l = j; l >= 0; l--) {
                    if (grid[i][l] == 0)
                        break;
                    segmentHorizontal.add(grid[i][l]);
                    if (areMakingL(segmentHorizontal, segmentVertical)) {
                        result++;
                    }
                }
            }

        } else {

            ArrayList<Integer> segmentVertical = new ArrayList<>();
            for (int k = i; k < grid.length; k++) {
                if (grid[k][j] == 0) {
                    break;
                }
                segmentVertical.add(grid[k][j]);
                ArrayList<Integer> segmentHorizontal = new ArrayList<>();
                for (int l = j; l < grid[i].length; l++) {
                    if (grid[i][l] == 0)
                        break;
                    segmentHorizontal.add(grid[i][l]);
                    if (areMakingL(segmentHorizontal, segmentVertical)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private static boolean areMakingL(ArrayList<Integer> segmentHorizontal, ArrayList<Integer> segmentVertical) {
        if (((segmentHorizontal.size() == (2 * segmentVertical.size()))
                && segmentVertical.size() > 1)
                || ((2 * segmentHorizontal.size() ==
                segmentVertical.size()) && segmentHorizontal.size() > 1)){
            return true;
        }
        return false;
    }
}