package com.karn.leetcode;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        for (int target = 0; target < 70; target++) {
            System.out.println("for target " + target + " ");
//        int target=1;
            System.out.println(new SearchA2DMatrix().searchMatrix(matrix, target));
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return searchInMatrix(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target, true, true);
    }

    private boolean searchInMatrix(int[][] matrix, int i1, int j1, int i2, int j2, int target, boolean right, boolean left) {
        if (j1 == matrix[i1].length && right) {
            j1 = 0;
            i1++;
            if (i1 == matrix.length) {
                return false;
            }
        }
        if (j2 == -1 && left) {
            j2 = matrix[i2].length - 1;
            i2--;
            if (i2 == -1) {
                return false;
            }
        }
        int n = Integer.parseInt(i2 + "" + j2) - Integer.parseInt(i1 + "" + j1);
        if (n < 0) {
            return false;
        }
        if (matrix[i1][j1] == target || matrix[i2][j2] == target) {
            return true;
        }

        int i = (i1 + i2) / 2;
        int j = (j1 + j2) / 2;
        if ((i2 - i1) % 2 != 0) {
            j = matrix[i].length - 1;
        }
        if (matrix[i][j] == target) {
            return true;
        }
        if (matrix[i][j] < target) {
            //search right
            return searchInMatrix(matrix, i, j + 1, i2, j2, target, true, false);
        } else {
            //search left
            return searchInMatrix(matrix, i1, j1, i, j - 1, target, false, true);
        }
    }
}
