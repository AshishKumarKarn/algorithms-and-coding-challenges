package com.karn.leetcode;

import java.util.ArrayList;
import java.util.List;


//TODO: NOT ALL TEST CASE PASSING AMBIGUITY IN UNDERSTANDING
public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (i == 2 && j == 1) {
                    int x = 7;
                }
                if (findPositions(heights, i, j)) {
                    List<Integer> res = new ArrayList<>();
                    res.add(i);
                    res.add(j);
                    result.add(res);
                }
            }
        }
        return result;
    }

    private boolean findPositions(int[][] grid, int i, int j) {
        boolean result;
        int sum = i + j;
        boolean pacific = isPacific(sum, grid.length, grid[i].length);
        boolean border = isBorder(sum, grid.length, grid[i].length);

        //if position is in pacific
        if (pacific) {
            result = checkIfItCanPass(grid, (i + 1), j, grid[i][j], true, false, false) ||
                    checkIfItCanPass(grid, i, j + 1, grid[i][j], true, false, false);
        } else if (border) {
            //border
            result = (checkIfItCanPass(grid, (i - 1), j, grid[i][j], false, false, true)
                    || checkIfItCanPass(grid, i, j - 1, grid[i][j], false, false, true))
                    ||
                    (checkIfItCanPass(grid, (i + 1), j, grid[i][j], false, false, true)
                            || checkIfItCanPass(grid, i, j + 1, grid[i][j], false, false, true));
        } else {
            result = checkIfItCanPass(grid, (i - 1), j, grid[i][j], false, true, false) ||
                    checkIfItCanPass(grid, i, j - 1, grid[i][j], false, true, false);
        }
        return result;
    }

    private boolean isBorder(int sum, int length, int width) {
        return sum == Math.max(length, width) - 1;
    }

    private boolean isPacific(int sum, int gridHeight, int gridWidth) {
        return sum < Math.max(gridHeight, gridWidth) - 1;
    }

    private boolean isAtlantic(int sum, int gridHeight, int gridWidth) {
        return sum > Math.max(gridHeight, gridWidth) - 1;
    }

    private boolean checkIfItCanPass(int[][] grid, int i, int j, int val, boolean pacific, boolean atlantic, boolean border) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return false;
        }
        boolean isCurrentAtlantic = isAtlantic(i + j, grid.length, grid[i].length);
        boolean isCurrentPacific = isPacific(i + j, grid.length, grid[i].length);
        boolean isCurrentBorder = isBorder(i+j,grid.length,grid[i].length);
        if ((pacific && isCurrentAtlantic)
                || (atlantic && isCurrentPacific)
                || (border&&isCurrentAtlantic)
                ||(border&&isCurrentPacific)) {
            //if originated with Pacific and reached Atlantic
            //OR if originated with the Atlantic ocean and reached pacific
            //Or if originated from border
            return grid[i][j] <= val;
        }
        if (grid[i][j] <= val&&pacific) {
            return checkIfItCanPass(grid, (i + 1), j, grid[i][j], true, false, false) ||
                    checkIfItCanPass(grid, i, (j + 1), grid[i][j], true, false, false);
        }
        if (grid[i][j] <= val && atlantic) {
            return checkIfItCanPass(grid, (i - 1), j, grid[i][j], false, true, false) ||
                    checkIfItCanPass(grid, i, (j - 1), grid[i][j], false, true, false);
        }

        //border case
        if(grid[i][j] <= val){
            return checkIfItCanPass(grid, (i - 1), j, grid[i][j], false, false, true)
                    ||checkIfItCanPass(grid, i, (j - 1), grid[i][j], false, false, true)
                    ||checkIfItCanPass(grid, (i+1), j, grid[i][j], false, false, true)
                    ||checkIfItCanPass(grid, i, (j + 1), grid[i][j], false, false, true)
                    ;

        }
        return false;
    }
}
