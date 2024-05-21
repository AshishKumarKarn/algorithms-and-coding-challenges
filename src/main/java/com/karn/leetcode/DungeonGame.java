package com.karn.leetcode;



public class DungeonGame {
    public static void main(String[] args) {
//        int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
//        int[][] arr = {{2,1},{1,-1}};
//        int[][] arr = {{1,-3,3},{0,-2,0},{-3,-3,-3}};
        int[][] arr = {{1,-4,5,-99},{2,-2,-2,-1}};
        System.out.println(new DungeonGame().calculateMinimumHP(arr));
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        // Initialize the dp array for the bottom-right cell
        dp[m-1][n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);

        // Fill the last row
        for (int j = n - 2; j >= 0; j--) {
            dp[m-1][j] = Math.max(1, dp[m-1][j+1] - dungeon[m-1][j]);
        }

        // Fill the last column
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n-1] = Math.max(1, dp[i+1][n-1] - dungeon[i][n-1]);
        }

        // Fill the rest of the dp array
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(1, dp[i+1][j] - dungeon[i][j]);
                int right = Math.max(1, dp[i][j+1] - dungeon[i][j]);
                dp[i][j] = Math.min(down, right);
            }
        }

        // The answer is the minimum health needed at the start cell
        return dp[0][0];
    }

}
