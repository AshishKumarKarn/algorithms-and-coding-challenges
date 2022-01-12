package com.karn.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class CherryPickupII_1463 {

    public int cherryPickup(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length <= 1) {
            return 0;
        }

        int bot1Collection = grid[0][0];
        int bot2Collection = grid[0][grid.length - 1];
        int result = (bot1Collection + bot2Collection);
        int[] pos1 = {0, 0};
        int[] pos2 = {0, grid.length - 1};
        result = collect(result, grid, 0, 0, 0, grid.length - 1);
        return result;
    }

    private int collect(int result, int[][] grid, int x1, int y1, int x2, int y2) {
        int max = result, r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0, r6 = 0, r7 = 0, r8 = 0, r9 = 0;
        //pos1 and pos2 within grid
        if (y1 < grid[0].length && y1 >= 0 && x1 < grid.length
                && y2 < grid[0].length && y2 >= 0 && x2 < grid.length  && y1 != y2) {
            r1 = result + grid[x1][y1] + grid[x2][y2] +
                    collect(result, grid, x1 + 1, y1 - 1, x2 + 1, y2 - 1);
            r2 = result + grid[x1][y1] + grid[x2][y2] +
                    collect(result, grid, x1 + 1, y1 - 1, x2 + 1, y2);
            r3 = result + grid[x1][y1] + grid[x2][y2] +
                    collect(result, grid, x1 + 1, y1 - 1, x2 + 1, y2 + 1);
            r4 = result + grid[x1][y1] + grid[x2][y2] +
                    collect(result, grid, x1 + 1, y1, x2 + 1, y2 - 1);
            r5 = result + grid[x1][y1] + grid[x2][y2] +
                    collect(result, grid, x1 + 1, y1, x2 + 1, y2);
            r6 = result + grid[x1][y1] + grid[x2][y2] +
                    collect(result, grid, x1 + 1, y1, x2 + 1, y2 + 1);
            r7 = result + grid[x1][y1] + grid[x2][y2] +
                    collect(result, grid, x1 + 1, y1 + 1, x2 + 1, y2 - 1);
            r8 = result + grid[x1][y1] + grid[x2][y2] +
                    collect(result, grid, x1 + 1, y1 + 1, x2 + 1, y2);
            r9 = result + grid[x1][y1] + grid[x2][y2] +
                    collect(result, grid, x1 + 1, y1 + 1, x2 + 1, y2 + 1);

        } else if(y1==y2){
            return -1;
        }
        if (x1 == grid.length - 1) {

            max = grid[x1][y1] + grid[x2][y2] + Collections.max(Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9));
        }
        return max;
    }
}
