package com.karn.algosolutions.codility;


import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
//        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] grid = {{2, 1, 1}, {1, 1, 1}, {0, 1, 2}};
        System.out.println(new RottenOranges().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }
        int count = process(queue, grid);
        for (int[] rows : grid) {
            for (int elements : rows) {
                if (elements == 1) {
                    return -1;
                }
            }
        }
        return count;
    }

    private int process(Queue<int[]> queue, int[][] grid) {
        int maxTime = 0;
        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            int i = location[0];
            int j = location[1];
            int time = location[2];
            maxTime = Math.max(maxTime, time);
            makeRotten(i - 1, j, time+1, grid, queue);
            makeRotten(i + 1, j, time+1,grid, queue);
            makeRotten(i, j - 1, time+1,grid, queue);
            makeRotten(i, j + 1, time+1,grid, queue);
        }

        return maxTime;

    }

    private void makeRotten(int i, int j, int time, int[][] grid, Queue<int[]> queue) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        queue.add(new int[]{i, j, time});
    }

}
