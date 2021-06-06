package com.karn.algosolutions;

import java.util.Arrays;

public class NQueen {
    public static void main(String[] args) {
        int n = 5;
        Position[] positions = solveNQueen(n);
        System.out.printf("Solution %s", Arrays.toString(positions));
    }

    private static Position[] solveNQueen(int n) {
        Position[] solutions = new Position[n];
        if (solveNQueenUtil(0, n, solutions)) {
            return solutions;
        }
        return new Position[0];
    }

    private static boolean solveNQueenUtil(int currentRow, int n, Position[] solutions) {
        if (currentRow == n) {
            return true;
        }
        //check possible placement of current queen in all columns
        for (int col = 0; col < n; col++) {
            boolean foundSafe = true;

            //check if any previous queen's (row,col) is attacking current (row,col)
            //no need to check row attack as i != currentRow in below case as we are checking for all
            //previous queens only
            for (int i = 0; i < currentRow; i++) {
                if (solutions[i].col == col
                        || solutions[i].row - solutions[i].col == currentRow - col
                        || solutions[i].row + solutions[i].col == currentRow + col) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                solutions[currentRow] = new Position(currentRow, col);
                if (solveNQueenUtil(currentRow + 1, n, solutions)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class Position {
        private final int row;
        private final int col;

        private Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return row + "," + col;
        }
    }
}