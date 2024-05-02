package com.karn.leetcode;

import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
//        int[][] grid = {
//                {1,4,2,0},
//                {4,1,1,0}
//        };
        int[][] grid = {
                {1, 4, 8, 6, 2, 2, 1, 7},
                {4, 7, 3, 1, 4, 5, 5, 1},
                {8, 8, 2, 1, 1, 8, 0, 1},
                {8, 9, 2, 9, 8, 0, 8, 9},
                {5, 7, 5, 7, 1, 8, 5, 5},
                {7, 0, 9, 4, 5, 6, 5, 6},
                {4, 9, 9, 7, 9, 1, 9, 0}
        };
        System.out.println(new MinPathSum().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        dp=new int[grid.length][grid[0].length];
        for (int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        int res = minPathSum(grid.length - 1, grid[0].length - 1, grid);
//        for(int[] g:grid){
//            System.out.println(Arrays.toString(g));
//        }
        return res;
    }
    int[][] dp;

    private int minPathSum(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i == 0) {
            int sum = 0;
            for (int k = j; k >= 0; k--) {
                sum += grid[0][k];
            }
            return sum;

        }

        if (j == 0) {
            int sum = 0;
            for (int k = i; k >= 0; k--) {
                sum += grid[k][0];
            }
            return sum;
        }
        if(dp[i][j]!=-1){
            return grid[i][j];
        }


        grid[i][j] = grid[i][j] + Math.min(minPathSum(i - 1, j, grid), minPathSum(i, j - 1, grid));
        dp[i][j]=grid[i][j];
        return dp[i][j];
    }
}
