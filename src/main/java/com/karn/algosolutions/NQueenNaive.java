package com.karn.algosolutions;

import java.util.Arrays;

public class NQueenNaive {
    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        solve(board, 0, 0, n);
        System.out.println(Arrays.deepToString(board));
    }

    private static void solve(int[][] board, int r, int c, int n) {
        if (r == n) {
            return;
        }
        for (int i = r; i < n; i++) {
            for (int j = c; j < n; j++) {
                if (isSafe(i, j, board)) {
                    board[i][j] = 1;
                    solve(board, r + 1, c, n);
                } else {
                    //backtrack
                    board[i][j] = 0;
                    solve(board, r, c + 1, n);
                }
            }
        }
    }

    private static boolean isSafe(int i, int j, int[][] board) {
        for (int k = 0; k <= i; k++) {
            for (int l = 0; l < board[k].length; l++) {
                if (i + j == l + k || i - j == l - k || l == j || k == i) {
                    if (board[k][l] == 1) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

}
