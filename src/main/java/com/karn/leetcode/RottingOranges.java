package com.karn.leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        return orangesRotting(grid, 0);
    }

    private final Set<String> visited = new HashSet<>();
    private final Queue<String> queue = new ArrayDeque<>();

    private int orangesRotting(int[][] grid, int result) {
        boolean operated = false;
        boolean hasOne = false;
        for (int k = 0; k < grid.length; k++) {
            for (int l = 0; l < grid[k].length; l++) {
                String index = k + "_" + l;
                if (grid[k][l] == 2 && !visited.contains(index)) {
                    visited.add(index);
                    queue.add(index);
                }
                if (grid[k][l] == 1) {
                    hasOne = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            String[] s = poll.split("_");
            int k = Integer.parseInt(s[0]);
            int l = Integer.parseInt(s[1]);
            boolean r1 = incrementNeighbour(grid, k + 1, l);
            boolean r2 = incrementNeighbour(grid, k, l - 1);
            boolean r3 = incrementNeighbour(grid, k, l + 1);
            boolean r4 = incrementNeighbour(grid, k - 1, l);
            if (r1 || r2 || r3 || r4) {
                operated = true;
            }
        }
        if (operated) {
            return orangesRotting(grid, ++result);
        }
        if (hasOne) {
            return -1;
        } else {
            return result;
        }
    }

    private boolean incrementNeighbour(int[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[i].length && grid[i][j] == 1) {
            grid[i][j] = 2;
            return true;
        }
        return false;
    }
}
