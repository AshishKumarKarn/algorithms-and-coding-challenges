package com.karn.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        Set<Integer> rowList = new HashSet<>();
        Set<Integer> colList = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowList.add(i);
                    colList.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowList.contains(i) || colList.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

}
