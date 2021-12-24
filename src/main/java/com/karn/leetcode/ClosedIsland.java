package com.karn.leetcode;

public class ClosedIsland {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (grid[i][j] == 0) {
                    if (checkSurrounded(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean checkSurrounded(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > (grid.length - 1) || j > (grid[i].length - 1)) {
            return false;
        } else {
            if (grid[i][j] == 1) {
                return true;
            } else {
                grid[i][j] = 1;
                if( checkSurrounded(grid, i + 1, j) && checkSurrounded(grid, i-1 , j)
                        && checkSurrounded(grid, i, j - 1) && checkSurrounded(grid, i, j + 1))
                    return true;
                else {
                    //rollback
                    grid[i][j] = 0;
                    return false;
                }
            }

        }
    }
}