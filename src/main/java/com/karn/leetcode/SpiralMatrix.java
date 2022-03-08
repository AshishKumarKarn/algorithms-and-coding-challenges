package com.karn.leetcode;

import java.util.*;

public class SpiralMatrix {

    private Set<String> visited = new HashSet<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        List<Integer> result = new LinkedList<>();
        result.add(matrix[0][0]);
        visited.add(0 + "_" + 0);


        return spiralOrderFetcher(0, 0, matrix, result, Direction.RIGHT);
    }

    enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

    private List<Integer> spiralOrderFetcher(int i, int j, int[][] matrix, List<Integer> result, Direction direction) {
        switch (direction) {
            case RIGHT:
                String nextRightStep = i + "_" + (j + 1);
                if ((j + 1 == matrix[i].length) || visited.contains(nextRightStep)) {
                    direction = Direction.DOWN;
                }
                break;
            case DOWN:
                String nextDownStep = (i + 1) + "_" + j;
                if ((i + 1 == matrix.length) || visited.contains(nextDownStep)) {
                    direction = Direction.LEFT;
                }
                break;
            case LEFT:
                String nextLeftStep = i + "_" + (j - 1);
                if ((j == 0) || visited.contains(nextLeftStep)) {
                    direction = Direction.UP;
                }
                break;
            case UP:
                String nextUpStep = i - 1 + "_" + j;
                if ((i == 0) || visited.contains(nextUpStep)) {
                    direction = Direction.RIGHT;
                }
                break;
        }
        switch (direction) {
            case RIGHT:
                String nextRightStep = i + "_" + (j + 1);
                if (visited.contains(nextRightStep) || j + 1 == matrix[i].length) {
                    return result;
                } else {
                    visited.add(nextRightStep);
                    result.add(matrix[i][j + 1]);
                    return spiralOrderFetcher(i, j + 1, matrix, result, Direction.RIGHT);
                }
            case DOWN:
                String nextDownStep = (i + 1) + "_" + j;
                if (visited.contains(nextDownStep) || i + 1 == matrix.length) {
                    return result;
                } else {
                    visited.add(nextDownStep);
                    result.add(matrix[i + 1][j]);
                    return spiralOrderFetcher(i + 1, j, matrix, result, Direction.DOWN);
                }
            case LEFT:
                String nextLeftStep = i + "_" + (j - 1);
                if (visited.contains(nextLeftStep) || j == 0) {
                    return result;
                } else {
                    visited.add(nextLeftStep);
                    result.add(matrix[i][j - 1]);
                    return spiralOrderFetcher(i, j - 1, matrix, result, Direction.LEFT);
                }
            case UP:
                String nextUpStep = i - 1 + "_" + j;
                if (visited.contains(nextUpStep) || i == 0) {
                    return result;
                } else {
                    visited.add(nextUpStep);
                    result.add(matrix[i - 1][j]);
                    return spiralOrderFetcher(i - 1, j, matrix, result, Direction.UP);
                }
        }
        return result;
    }
}
