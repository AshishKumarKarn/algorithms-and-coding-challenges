package com.karn.leetcode;

import java.util.Arrays;
// todo: unresolved
public class CountSubIslands {
    public static void main(String[] args) {
        System.out.println();
        int[][] grid1 = {{1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}};
        int[][] grid2 = {{0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 1, 0}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}};
        System.out.println(new CountSubIslands()
                .countSubIslands(grid1, grid2));
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[i].length; j++) {
                if (grid1[i][j] == 1 && grid2[i][j] == 1) {
                    int c = dfs(grid1, grid2, i, j);
                    System.out.println("c is " + c+" i= "+i+" j= "+j);
                    count += c;
                }
            }
        }
        System.out.println(Arrays.deepToString(grid2));
        return count;
    }

    private int dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i >= 0 && i < grid1.length && j >= 0 && j < grid1[i].length) {
            if (grid1[i][j] == 1 && grid2[i][j] == 1) {
                grid1[i][j] = 0;
                if (dfs(grid1, grid2, i + 1, j) == 1 && dfs(grid1, grid2, i - 1, j) == 1 & dfs(grid1, grid2, i, j + 1) == 1 && dfs(grid1, grid2, i, j - 1) == 1) {
                    return 1;
                } else {
                    return 0;
                }
            } else if (grid2[i][j] == 1) {
                return 0;
            } else if (grid1[i][j] == 1) {
                return 1;
            }
        }
        return 1;
    }
}
